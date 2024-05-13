package com.emuntiy.rest.webservice.pojo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="user" , uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String user_id;
	private String name;
	private int age;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	public User(String user_id, String name, int age, String username, String passward) {
		this.user_id = user_id;
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = passward;
	}
	public User() {}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassward() {
		return password;
	}
	public void setPassward(String passward) {
		this.password = passward;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", age=" + age + ", username=" + username + ", passward="
				+ password + "]";
	}
	

}
