package it.solutionsexmachina.security.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Webarea
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
	private String				url;
	private String				description;

	@ManyToMany(mappedBy = "areas")
	private Set<Webrole>		roles				= new HashSet<Webrole>();

	public Webarea()
	{}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Set<Webrole> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Webrole> roles)
	{
		this.roles = roles;
	}

}
