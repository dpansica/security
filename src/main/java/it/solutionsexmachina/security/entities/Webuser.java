package it.solutionsexmachina.security.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Webuser
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

	private String				username;
	private String				firstname;
	private String				lastname;
	private String				affiliation;
	private Date				dob;
	private String				email;
	private String				password;
	private Boolean				enabled;
	private Character			gender;

	@OneToOne
	private Webgroup			webgroup;

	@OneToMany
	private Set<Webrole>		roles				= new HashSet<Webrole>();

	public Webuser()
	{}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Boolean getEnabled()
	{
		return enabled;
	}

	public void setEnabled(Boolean enabled)
	{
		this.enabled = enabled;
	}

	public Character getGender()
	{
		return gender;
	}

	public void setGender(Character gender)
	{
		this.gender = gender;
	}

	public String getAffiliation()
	{
		return affiliation;
	}

	public void setAffiliation(String affiliation)
	{
		this.affiliation = affiliation;
	}

	public Webgroup getWebgroup()
	{
		return webgroup;
	}

	public void setWebgroup(Webgroup webgroup)
	{
		this.webgroup = webgroup;
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
