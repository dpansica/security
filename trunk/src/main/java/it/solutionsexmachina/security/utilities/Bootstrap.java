package it.solutionsexmachina.security.utilities;



import it.solutionsexmachina.genericdao.jpa.JpaGenericDAO;
import it.solutionsexmachina.security.entities.Webarea;
import it.solutionsexmachina.security.entities.Webgroup;
import it.solutionsexmachina.security.entities.Webrole;
import it.solutionsexmachina.security.entities.Webuser;
import it.solutionsexmachina.security.jaas.data.ProfileDataMarkup;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bootstrap
{

	public static void loadInitialData() throws Throwable
	{
//		JpaGenericDAO<Webgroup> daoGroup = new JpaGenericDAO<Webgroup>(Webgroup.class);
//		JpaGenericDAO<Webrole> daoRole = new JpaGenericDAO<Webrole>(Webrole.class);
//		JpaGenericDAO<Webarea> daoArea = new JpaGenericDAO<Webarea>(Webarea.class);
//
//		List<Webgroup> groups = daoGroup.findAll();
//		List<Webrole> roles = daoRole.findAll();
//		List<Webarea> areas = daoArea.findAll();
//
//		if (groups.size() == 0 && roles.size() == 0 && areas.size() == 0)
//		{
//			loadGroupsAndRoles();
//		}
	}

	public void loadInitialUsers() throws Exception
	{
		String password = "welld";
		ProfileDataMarkup.UserTypeEnum type = ProfileDataMarkup.UserTypeEnum.SUPERADMIN;
		Webuser user = new Webuser();
		user.setUsername(type.name());
		user.setFirstname(type.name());
		user.setLastname(type.name());
		user.setDob(new Date());
		user.setPassword(password);
		user.setEmail(type + "@welld.ch");
		user.setEnabled(Boolean.TRUE);

//		RegisterUtils.registerNewUserByType(user, type);

	}

//	public static void loadGroupsAndRoles()
//	{
//
//		JpaGenericDAO<Webgroup> daoGroup = new JpaGenericDAO<Webgroup>(Webgroup.class);
//		JpaGenericDAO<Webrole> daoRole = new JpaGenericDAO<Webrole>(Webrole.class);
//		JpaGenericDAO<Webarea> daoArea = new JpaGenericDAO<Webarea>(Webarea.class);
//
//		ProfileDataMarkup.AreaEnum[] areas = ProfileDataMarkup.AreaEnum.values();
//		for (int i = 0; i < areas.length; i++)
//		{
//			Webarea area = new Webarea();
//			area.setName(areas[i].name());
//
//			List<Webarea> areaOnDb = daoArea.findByExample(area);
//			if (areaOnDb.size() > 0)
//			{
//				area = areaOnDb.get(0);
//			}
//			area.setDescription(areas[i].areaDescription());
//			area.setUrl(areas[i].url());
//			daoArea.save(area);
//		}
//
////		DecorateRequestFilter.entityManager.get().flush();
//
//		ProfileDataMarkup.RoleEnum[] roles = ProfileDataMarkup.RoleEnum.values();
//		for (int i = 0; i < roles.length; i++)
//		{
//			Webrole role = new Webrole();
//			role.setName(roles[i].name());
//
//			List<Webrole> roleOnDb = daoRole.findByExample(role);
//			if (roleOnDb.size() > 0)
//			{
//				role = roleOnDb.get(0);
//			}
//			role.setDescription(roles[i].roleDescription());
//			role.setIsConditionChecked(roles[i].condition());
//
//
//			Set<Webarea> dbAreas = new HashSet<Webarea>();
//			ProfileDataMarkup.AreaEnum[] areasPermitted = roles[i].areasPermitted();
//			for (int j = 0; j < areasPermitted.length; j++)
//			{
//				Webarea areaToFind = new Webarea();
//				areaToFind.setName(areasPermitted[j].name());
//
//				List<Webarea> areaOnDb = daoArea.findByExample(areaToFind);
//				if (areaOnDb.size() > 0)
//				{
//					dbAreas.addAll(areaOnDb);
//				}
//			}
//			role.setAreas(dbAreas);
//			daoRole.save(role);
//
//		}
//
////		DecorateRequestFilter.entityManager.get().flush();
//
//		ProfileDataMarkup.GroupEnum[] groups = ProfileDataMarkup.GroupEnum.values();
//		for (int i = 0; i < groups.length; i++)
//		{
//			Webgroup group = new Webgroup();
//			group.setName(groups[i].name());
//
//			List<Webgroup> groupOnDb = daoGroup.findByExample(group);
//			if (groupOnDb.size() > 0)
//			{
//				group = groupOnDb.get(0);
//			}
//			group.setDescription(groups[i].groupDescription());
//
//			Set<Webrole> dbRoles = new HashSet<Webrole>();
//			ProfileDataMarkup.RoleEnum[] groupRoles = groups[i].groupRoles();
//			for (int j = 0; j < groupRoles.length; j++)
//			{
//				Webrole roleToFind = new Webrole();
//				roleToFind.setName(groupRoles[j].name());
//
//				List<Webrole> roleOnDb = daoRole.findByExample(roleToFind);
//				dbRoles.addAll(roleOnDb);
//			}
//			group.setRoles(dbRoles);
//			daoGroup.save(group);
//		}
//
////		DecorateRequestFilter.entityManager.get().flush();
//	}

}
