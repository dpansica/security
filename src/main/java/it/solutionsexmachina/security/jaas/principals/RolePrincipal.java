package it.solutionsexmachina.security.jaas.principals;

import java.security.Principal;

public class RolePrincipal implements Principal, java.io.Serializable
{

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	private String				name;

	public RolePrincipal(String name)
	{
		if (name == null) throw new NullPointerException("illegal null input");

		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String toString()
	{
		return ("RolePrincipal:  " + name);
	}

	public boolean equals(Object o)
	{
		if (o == null) return false;

		if (this == o) return true;

		if (!(o instanceof RolePrincipal)) return false;
		RolePrincipal that = (RolePrincipal) o;

		if (this.getName().equals(that.getName())) return true;
		return false;
	}

	public int hashCode()
	{
		return name.hashCode();
	}
}
