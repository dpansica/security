package it.solutionsexmachina.security.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Webrole
{
	@Id
	private String id;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@PrePersist
	void generateId()
	{
		setId(UUID.randomUUID().toString().replaceAll("-", ""));
	}
	private String				name;
	private String				description;
	private Boolean				isConditionChecked;

	@ManyToMany()
	private Set<Webarea>		areas				= new HashSet<Webarea>();

	public Webrole()
	{}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Boolean getIsConditionChecked()
	{
		return isConditionChecked;
	}

	public void setIsConditionChecked(Boolean isConditionChecked)
	{
		this.isConditionChecked = isConditionChecked;
	}

	public Set<Webarea> getAreas()
	{
		return areas;
	}

	public void setAreas(Set<Webarea> areas)
	{
		this.areas = areas;
	}

}
