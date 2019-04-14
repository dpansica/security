package it.solutionsexmachina.security.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class WebuserAttribute
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

	private String				key;
	private String				value;
	private String				type;
	private String				params;
	private String				description;
	private Long				ordinal;
	private Boolean				required;

	public WebuserAttribute()
	{}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getParams()
	{
		return params;
	}

	public void setParams(String params)
	{
		this.params = params;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Long getOrdinal()
	{
		return ordinal;
	}

	public void setOrdinal(Long ordinal)
	{
		this.ordinal = ordinal;
	}

	public Boolean getRequired()
	{
		return required;
	}

	public void setRequired(Boolean required)
	{
		this.required = required;
	}

}
