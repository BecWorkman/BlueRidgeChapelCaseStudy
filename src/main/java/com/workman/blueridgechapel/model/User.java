package com.workman.blueridgechapel.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate user creation and 
 * getting user information. 
 *
 */

@Entity
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique= true)
	private String email;
	@Column(nullable=false)
	private String password;
	private String status;
	

		
	public User() {}

	public User(String name, String email, String password, String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(status, other.status)
				;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status +  ", userReservations=" + "]";
	}


 

}
