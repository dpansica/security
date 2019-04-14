package it.solutionsexmachina.security.jaas.login;

import it.solutionsexmachina.security.actionbeans.UserManager;
import it.solutionsexmachina.security.entities.Webarea;
import it.solutionsexmachina.security.entities.Webrole;
import it.solutionsexmachina.security.entities.Webuser;
import it.solutionsexmachina.security.jaas.principals.RolePrincipal;
import it.solutionsexmachina.security.jaas.principals.UserPrincipal;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ObjectdbLoginModule implements LoginModule
{

	private Subject			subject;
	private CallbackHandler	callbackHandler;
	private Map<String, ?>	sharedState;
	private Map<String, ?>	options;

	private boolean			debug			= false;

	private boolean			succeeded		= false;
	private boolean			commitSucceeded	= false;

	private Webuser			loggedUser;

	private UserPrincipal	userPrincipal;

	private EntityManagerFactory emf = null;
	private EntityManager entityManager = null;

	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options)
	{
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;

		debug = "true".equalsIgnoreCase((String) options.get("debug"));
	}

	public boolean login() throws LoginException
	{

		// prompt for a user name and password
		if (callbackHandler == null) throw new LoginException("Error: no CallbackHandler available " + "to garner authentication information from the user");

		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("user name: ");
		callbacks[1] = new PasswordCallback("password: ", false);

		try
		{
			callbackHandler.handle(callbacks);
			String username = ((NameCallback) callbacks[0]).getName();
			char[] password = ((PasswordCallback) callbacks[1]).getPassword();
			if (password == null)
			{
				// treat a NULL password as an empty password
				password = new char[0];
			}
			((PasswordCallback) callbacks[1]).clearPassword();

			UserManager userManager = CDI.current().select(UserManager.class).get();

			Webuser user = new Webuser();
			user.setUsername(username);
			user.setPassword(new String(password));
			user.setEnabled(true);

			user = userManager.login(user);

			if (user!=null)
			{
				loggedUser = user;
				succeeded = true;
				return true;
			}
			else
			{
				succeeded = false;
				username = null;
				for (int i = 0; i < password.length; i++)
				{
					password[i] = ' ';
				}
				password = null;

				throw new FailedLoginException("Username or password Incorrect");

			}

		}
		catch (IOException ioe)
		{
			throw new LoginException(ioe.toString());
		}
		catch (UnsupportedCallbackException uce)
		{
			throw new LoginException("Error: " + uce.getCallback().toString() + " not available to garner authentication information " + "from the user");
		}
	}

	public boolean commit() throws LoginException
	{
		if (succeeded == false)
		{
			return false;
		}
		else
		{
			userPrincipal = new UserPrincipal(loggedUser.getId(), loggedUser.getUsername());
			if (!subject.getPrincipals().contains(userPrincipal))
			{
				subject.getPrincipals().add(userPrincipal);
			}

			Set<Webrole> roles = loggedUser.getRoles();
			for (Iterator<Webrole> iterator = roles.iterator(); iterator.hasNext();)
			{
				Webrole webrole = iterator.next();
				RolePrincipal rolePrincipal = new RolePrincipal(webrole.getName());
				if (!subject.getPrincipals().contains(rolePrincipal))
				{
					Set<Webarea> areas = webrole.getAreas();
					for (Iterator<Webarea> iterator2 = areas.iterator(); iterator2.hasNext();)
					{
						subject.getPrincipals().add(rolePrincipal);

						Webarea webarea = iterator2.next();
						String areaRoleName = "url:" + webarea.getUrl();
						RolePrincipal areaPrincipal = new RolePrincipal(areaRoleName);
						if (!subject.getPrincipals().contains(areaPrincipal))
						{
							subject.getPrincipals().add(areaPrincipal);
						}
					}
				}
			}

			commitSucceeded = true;


		}

		return true;
	}

	public boolean abort() throws LoginException
	{
		if (succeeded == false)
		{
			return false;
		}
		else if (succeeded == true && commitSucceeded == false)
		{
			succeeded = false;
			userPrincipal = null;
		}
		else
		{
			logout();
		}
		return true;
	}

	public boolean logout() throws LoginException
	{
		subject.getPrincipals().remove(userPrincipal);
		succeeded = false;
		succeeded = commitSucceeded;
		userPrincipal = null;
		return true;
	}
}
