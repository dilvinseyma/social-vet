package com.socialvet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal implements Serializable{

	private static final long serialVersionUID = -4064626762339015114L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "GENUS")
	private String genus;
	
	@Column(name = "AGE")
	private String age;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
    @Column(name = "PETSITTER_USERNAME")
    private String petSitterUsername;
	
	@Column ( name = "STATUS")
	private boolean status= true; 
	
	@Column ( name = "CREATED_AT")
	private Date createdDate= new Date();
	
	@Column ( name = "UPDATED_AT")
	private Date updatedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPetSitterUsername() {
		return petSitterUsername;
	}

	public void setPetSitterUsername(String petSitterUsername) {
		this.petSitterUsername = petSitterUsername;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", type=" + type + ", genus=" + genus + ", age=" + age
				+ ", description=" + description + ", petSitterUsername=" + petSitterUsername + ", status=" + status
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
