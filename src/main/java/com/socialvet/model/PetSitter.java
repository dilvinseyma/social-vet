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
@Table(name = "PETSITTER")
public class PetSitter implements Serializable{

	private static final long serialVersionUID = 3094142315133512886L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "USERNAME", unique = true)
	private String username;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SURNAME")
	private String surName;
	
	@Column(name = "MAIL_ADDRESS")
	private String mailAddress;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column( name = "ADDRESS")
	private String address;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "PetSitter [id=" + id + ", username=" + username + ", name=" + name + ", surName=" + surName
				+ ", mailAddress=" + mailAddress + ", phoneNumber=" + phoneNumber + ", address=" + address + ", status="
				+ status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
