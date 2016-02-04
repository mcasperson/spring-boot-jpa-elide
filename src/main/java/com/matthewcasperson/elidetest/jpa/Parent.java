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

	private Integer id;

	private String description;

	private String name;

	private List<Child> children;

	public Parent() {
	}

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length=45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length=45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//bi-directional many-to-one association to Child
	@OneToMany(mappedBy="parent")
	@JsonManagedReference
	public List<Child> getChildren() {
		return this.children;
	}

	public void setChildren(List<Child> childs) {
		this.children = childs;
	}

	public Child addChild(Child child) {
		getChildren().add(child);
		child.setParent(this);

		return child;
	}

	public Child removeChild(Child child) {
		getChildren().remove(child);
		child.setParent(null);

		return child;
	}

}
