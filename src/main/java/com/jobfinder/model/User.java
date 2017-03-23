package com.jobfinder.model;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	private int id;
	private String username;
	private String password;
	private String passwordConfirm;
	private String type;

	private Set<Role> roles;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	@Transient
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String toString() {
		String result = "id: " + id + " username: " + username;
		return result;
	}
	
	public boolean hasRole(String roleName){
		for(Role role : roles){
			if(role.getName().equals(roleName)){
				return true;
			}
		}
		return false;
	}
}
