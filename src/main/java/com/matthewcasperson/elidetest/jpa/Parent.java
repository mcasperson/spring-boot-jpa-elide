package com.matthewcasperson.elidetest.jpa;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parent database table.
 * 
 */
@Entity
@Table(name="parent")
@NamedQuery(name="Parent.findAll", query="SELECT p FROM Parent p")
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length=45)
	private String description;

	@Column(length=45)
	private String name;

	//bi-directional many-to-one association to Child
	@OneToMany(mappedBy="parent")
	@JsonManagedReference
	private List<Child> childs;

	public Parent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getChilds() {
		return this.childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	public Child addChild(Child child) {
		getChilds().add(child);
		child.setParent(this);

		return child;
	}

	public Child removeChild(Child child) {
		getChilds().remove(child);
		child.setParent(null);

		return child;
	}

}
