package it.solutionsexmachina.security.jaas.principals;

import java.security.Principal;

public class UserPrincipal implements Principal, java.io.Serializable
{

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	private String				user;
	private String				name;

	public UserPrincipal(String user, String name)
	{
		if (user == null) throw new NullPointerException("illegal null input");

		this.user = user;
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String toString()
	{
		return ("UserPrincipal:  " + this.name);
	}

	public boolean equals(Object o)
	{
		if (o == null) return false;

		if (this == o) return true;

		if (!(o instanceof UserPrincipal)) return false;
		UserPrincipal that = (UserPrincipal) o;

		if (this.getName().equals(that.getName())) return true;
		return false;
	}

	public int hashCode()
	{
		return getName().hashCode();
	}

}
