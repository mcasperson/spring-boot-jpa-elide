package com.matthewcasperson.elidetest.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the child database table.
 * 
 */
@Entity
@Table(name="child")
@NamedQuery(name="Child.findAll", query="SELECT c FROM Child c")
public class Child implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String description;

	private String name;

	private Parent parent;

	public Child() {
	}

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	//bi-directional many-to-one association to Parent
	@ManyToOne
	@JoinColumn(name="parentId", nullable=false)
	@JsonBackReference
	public Parent getParent() {
		return this.parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}
