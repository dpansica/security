package it.solutionsexmachina.security.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class WebroleCondition
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
	private Webrole				webrole;
	private String				leftOperand;
	private String				rightOperand;

	public WebroleCondition()
	{}

	public Webrole getWebrole()
	{
		return webrole;
	}

	public void setWebrole(Webrole webrole)
	{
		this.webrole = webrole;
	}

	public String getLeftOperand()
	{
		return leftOperand;
	}

	public void setLeftOperand(String leftOperand)
	{
		this.leftOperand = leftOperand;
	}

	public String getRightOperand()
	{
		return rightOperand;
	}

	public void setRightOperand(String rightOperand)
	{
		this.rightOperand = rightOperand;
	}

}
