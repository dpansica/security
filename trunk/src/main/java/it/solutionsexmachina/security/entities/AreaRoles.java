package it.solutionsexmachina.security.entities;

import javax.persistence.*;

@Entity
public class AreaRoles
{

	@Id
	private Long				idArea;
	@Id
	private Long				idRole;

	public AreaRoles()
	{}

	public Long getIdArea()
	{
		return idArea;
	}

	public void setIdArea(Long idArea)
	{
		this.idArea = idArea;
	}

	public Long getIdRole()
	{
		return idRole;
	}

	public void setIdRole(Long idRole)
	{
		this.idRole = idRole;
	}

}
