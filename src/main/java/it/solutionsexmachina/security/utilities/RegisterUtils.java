package it.solutionsexmachina.security.utilities;

import java.io.Serializable;


public class RegisterUtils implements Serializable
{

	/**
	 *
	 */
	private static final long	serialVersionUID	= -2209284502393168881L;

//	public static Webuser registerNewUserByType(Webuser user, ProfileDataMarkup.UserTypeEnum userType) throws Exception
//	{
//		try
//		{
//			Bootstrap.loadInitialData();
//		}
//		catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
//
//		JpaGenericDAO<Webuser> daoUser = new JpaGenericDAO<Webuser>(Webuser.class);
//		JpaGenericDAO<Webgroup> daoGroup = new JpaGenericDAO<Webgroup>(Webgroup.class);
//		JpaGenericDAO<Webrole> daoRole = new JpaGenericDAO<Webrole>(Webrole.class);
////		JpaGenericDAO<WebuserAttribute> daoAttribute = new JpaGenericDAO<WebuserAttribute>(WebuserAttribute.class);
//
////		if (user.getId() == null)
////		{
////			Webuser example = new Webuser();
////			example.setUsername(user.getUsername());
////
////			List<Webuser> result = daoUser.findByExample(user);
////
////			if (result.size() > 0)
////			{
////				throw new Exception("UsernameUsed");
////			}
////			example = new Webuser();
////			example.setEmail(user.getEmail());
////			result = daoUser.findByExample(user);
////			if (result.size() > 0)
////			{
////				throw new Exception("UsernameUsed");
////			}
////		}
//
//		ProfileDataMarkup.GroupEnum groupEnum = userType.group();
//		Webgroup groupExample = new Webgroup();
//		groupExample.setName(groupEnum.name());
//
//		List<Webgroup> groupsByName = daoGroup.findByExample(groupExample);
//
//		user.setWebgroup(groupsByName.get(0));
//
//		ProfileDataMarkup.RoleEnum[] roles = userType.roles();
//		Set<Webrole> dbRoles = new HashSet<Webrole>();
//		for (int i = 0; i < roles.length; i++)
//		{
//			Webrole roleExample = new Webrole();
//			roleExample.setName(roles[i].name());
//
//			List<Webrole> rolesByName = daoRole.findByExample(roleExample);
//
//			dbRoles.addAll(rolesByName);
//		}
//		user.setRoles(dbRoles);
//
//		// if (user.getWebfile() != null)
//		// {
//		// fileDao.saveOrUpdate(user.getWebfile());
//		// }
//		//
//		user.setPassword(user.getPassword());
//		user.setEnabled(true);
//
//		daoUser.save(user);
//
////		WebuserAttribute userTypeAttribute = new WebuserAttribute();
////		userTypeAttribute.setKey("USERTYPE");
////		userTypeAttribute.setQuantity(userType.name());
////		userTypeAttribute.setOrdinal(new Long(-1));
////		userTypeAttribute.setWebuser(user);
////
////		daoAttribute.save(userTypeAttribute);
////		user.getWebuserAttributes().add(userTypeAttribute);
////
////		daoUser.save(user);
//		//
//		// List<WebuserAttribute> attributesFromType =
//		// loadAttributesFromType(userType);
//		// for (Iterator<WebuserAttribute> iterator =
//		// attributesFromType.iterator(); iterator.hasNext();)
//		// {
//		// WebuserAttribute webuserAttribute = (WebuserAttribute)
//		// iterator.next();
//		// webuserAttribute.setWebuser(user);
//		// attributeDao.saveOrUpdate(webuserAttribute);
//		// }
//		// user.getWebuserAttributes().addAll(attributesFromType);
//		//
//		// daoUser.saveOrUpdate(user);
//
//		return user;
//	}


}
