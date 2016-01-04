package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Configuring O/R-Mapping via notations
@Entity(name="USERS") //Name of the database
public class User {
	
	//Attributes
	@Id @GeneratedValue //Configuring primary key (= id)
	private long id;
	private String userType;
	private String firstName;
	private String lastName;
	private String email;
	private String university;
	
	//Constructors
	public User(long id, String userType, String firstName, String lastName,
			String email, String university) {
		super();
		this.id = id;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.university = university;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getters and setters for external communication
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
	
}
