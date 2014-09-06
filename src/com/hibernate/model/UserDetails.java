package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="userdetail")
public class UserDetails {

	private int userId;

	private String address;

	private String city;

	private String state;

	private User user;

	public UserDetails() {
		super();
	}

	public UserDetails(int userId, String address, String city, String state,
			User user) {
		super();
		this.userId = userId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.user = user;
	}

	@Id
	@Column(name = "iduser")
	@GeneratedValue(generator = "forigngen")
	@GenericGenerator(name = "forigngen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@OneToOne
	@JoinColumn(name="iduser", updatable=false, insertable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
