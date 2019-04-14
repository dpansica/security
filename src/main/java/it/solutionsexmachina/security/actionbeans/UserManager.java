package it.solutionsexmachina.security.actionbeans;


import it.solutionsexmachina.genericdao.jpa.*;
import it.solutionsexmachina.security.entities.Webuser;
import it.solutionsexmachina.webcontroller.actionbean.GenericActionBean;
import it.solutionsexmachina.webcontroller.annotation.ServiceMethod;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("UserManager")
public class UserManager extends GenericActionBean
{
	@Inject
	@GenericDAO
	@DAOClass(Webuser.class)
	@DBMSUnit(DBMSPersistenceUnit.DBMS1)
	private JpaGenericDAO daoUser;

	@ServiceMethod("initialize")
	public String initialize(Webuser user)
	{
		return "";
	}

	@ServiceMethod("login")
	public Webuser login(Webuser user)
	{
		List<Webuser> users = daoUser.findByExample(user);
		return users.size()==1?users.get(0):null;
	}

}
