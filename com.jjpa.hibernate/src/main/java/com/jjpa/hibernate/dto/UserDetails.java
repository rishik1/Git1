package com.jjpa.hibernate.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;  //@EmbeddedId annotation for Pojo as PK or unique Id
	
	private String username;
	private Date joinedDate; //whole date
	
	@Temporal (TemporalType.TIME)
	private Date time;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="HOME_STREET__NAME")),
		@AttributeOverride(name="city",column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode",column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	@ElementCollection
	private Set<Address> listOfAddresses= new HashSet<Address>();
	
	@Lob    //BLOB ===> Byte Large set String LOb== > assume charactrer large String
	private String description; //huge amount of text more than 255 char string
	
	@Transient
	private String doNotPersistFeild;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoNotPersistFeild() {
		return doNotPersistFeild;
	}

	public void setDoNotPersistFeild(String doNotPersistFeild) {
		this.doNotPersistFeild = doNotPersistFeild;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
	

}
