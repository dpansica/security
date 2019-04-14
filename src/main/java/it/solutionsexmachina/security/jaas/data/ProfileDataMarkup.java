package it.solutionsexmachina.security.jaas.data;

/**
 * Used to define data structure and data itself using enumeration
 *
 * @author welld
 *
 */
public class ProfileDataMarkup
{

	public enum AreaEnum
	{
		SECURE("secure", "Superadmin Stuff Access Point"),
		BACKEND("backend", "Content Manager Access Point"),
		SERVLETS("servlets", "Servlets Access Point"),
		ACTION("action", "Ajax action bean Access Point");

		private final String	url;
		private final String	areaDescription;

		public String url()
		{
			return url;
		}

		public String areaDescription()
		{
			return areaDescription;
		}

		private AreaEnum(String url, String areaDescription)
		{
			this.url = url;
			this.areaDescription = areaDescription;
		}
	}

	public enum RoleEnum
	{
		SUPERADMIN("Super Administrator Role", false, new AreaEnum[] { AreaEnum.SECURE, AreaEnum.BACKEND, AreaEnum.ACTION }),
		CONTENTMANAGER("Content Manager Role", false, new AreaEnum[] { AreaEnum.BACKEND, AreaEnum.ACTION, }),
		DEFAULT("Default role", true, new AreaEnum[] { AreaEnum.SERVLETS, AreaEnum.ACTION, AreaEnum.SECURE });

		private final String		roleDescription;
		private final boolean		condition;
		private final AreaEnum[]	areasPermitted;

		public String roleDescription()
		{
			return roleDescription;
		}

		public boolean condition()
		{
			return condition;
		}

		public AreaEnum[] areasPermitted()
		{
			return areasPermitted;
		}

		private RoleEnum(String roleDescription, boolean condition, AreaEnum[] areasPermitted)
		{
			this.roleDescription = roleDescription;
			this.condition = condition;
			this.areasPermitted = areasPermitted;
		}
	}

	public enum GroupEnum
	{
		SUPERADMIN_GROUP("Super Administrator Group", new RoleEnum[] { RoleEnum.DEFAULT, RoleEnum.SUPERADMIN, RoleEnum.CONTENTMANAGER}), DEFAULT_GROUP("Default Group", new RoleEnum[] { RoleEnum.DEFAULT});

		private final String		groupDescription;
		private final RoleEnum[]	groupRoles;

		public String groupDescription()
		{
			return groupDescription;
		}

		public RoleEnum[] groupRoles()
		{
			return groupRoles;
		}

		private GroupEnum(String groupDescription, RoleEnum[] groupRoles)
		{
			this.groupRoles = groupRoles;
			this.groupDescription = groupDescription;
		}
	}

	public enum UserAttributeEnum
	{
		PATIENT_SCI_TYPE("SCI Type", "java.util.List", "PARAM.SCI_TYPE", 0, false), PATIENT_TIME_INJURY("Times since injury", "java.util.List", "PARAM.SCI_TIME", 2, false), PATIENT_CAUSE_INJURY("Cause of injury", "java.util.List", "PARAM.SCI_CAUSE_INJURY", 3, false), PATIENT_LIVE_ALONE("Do you live alone ?", "java.util.List", "YES,NO", 4, false),

		COMPANION_TYPE("Type", "java.util.List", "PARAM.COMPANION_TYPE", 0, false),

		HEALTH_PROFESSIONAL_BACKGROUND("Professional Background", "java.util.List", "PARAM.HEALTHCARE_BACKGROUND", 0, false), HEALTH_PROFESSIONAL_INSTITUTION("Institution", "java.lang.String", null, 1, false), HEALTH_PROFESSIONAL_PLACE_OF_WORK("Place of Work", "java.lang.String", null, 2, false),

		RESEARCHER_POSITION("Position", "java.lang.String", null, 0, false), RESEARCHER_INSTITUTION("Institution", "java.lang.String", null, 1, false), RESEARCHER_PLACE_OF_WORK("Place of Work", "java.lang.String", null, 3, false), RESEARCHER_TOPICS("Research Interests", "pickList", "PARAM.RESEARCHER_TOPICS", 4, false), SPG_MEMBER_FUNCTION("Function", "java.lang.String", null, 0, false);

		private final String	attributeDescription;
		private final String	attributeType;
		private final String	attributeParams;
		private final int		attributeOrdinalNumber;
		private final boolean	attributeRequired;

		public String attributeDescription()
		{
			return attributeDescription;
		}

		public String attributeType()
		{
			return attributeType;
		}

		public String attributeParams()
		{
			return attributeParams;
		}

		public int attributeOrdinalNumber()
		{
			return attributeOrdinalNumber;
		}

		public boolean attributeRequired()
		{
			return attributeRequired;
		}

		private UserAttributeEnum(String attributeDescription, String attributeType, String attributeParams, int attributeOrdinalNumber, boolean attributeRequired)
		{
			this.attributeDescription = attributeDescription;
			this.attributeType = attributeType;
			this.attributeParams = attributeParams;
			this.attributeOrdinalNumber = attributeOrdinalNumber;
			this.attributeRequired = attributeRequired;
		}
	}

	public enum UserTypeEnum
	{
		SUPERADMIN(GroupEnum.SUPERADMIN_GROUP, new UserAttributeEnum[] {}, new RoleEnum[] { RoleEnum.SUPERADMIN});

		private final GroupEnum				group;
		private final UserAttributeEnum[]	attributes;
		private final RoleEnum[]			roles;

		private UserTypeEnum(GroupEnum group, UserAttributeEnum[] attributes, RoleEnum[] roles)
		{
			this.group = group;
			this.attributes = attributes;
			this.roles = roles;
		}

		public GroupEnum group()
		{
			return group;
		}

		public UserAttributeEnum[] attributes()
		{
			return attributes;
		}

		public RoleEnum[] roles()
		{
			return roles;
		}

	};
}
