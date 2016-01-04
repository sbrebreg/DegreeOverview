package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Configuring O/R-Mapping via notations
@Entity(name="LECTURERS") //Name of the database
public class Lecturer extends User {
	
	//Attributes
	@Id @GeneratedValue //Configuring primary key (= id)
	private long lecturerId;
	private String firstName;
	private String lastName;
	private String email;
	private ArrayList<Course> taughtCourses = new ArrayList<Course>();
	
	//Constructors
	public Lecturer(long id, String userType, String firstName,
			String lastName, String email, String university, long lecturerId,
			String firstName2, String lastName2, String email2,
			ArrayList<Course> taughtCourses) {
		super(id, userType, firstName, lastName, email, university);
		this.lecturerId = lecturerId;
		firstName = firstName2;
		lastName = lastName2;
		email = email2;
		this.taughtCourses = taughtCourses;
	}

	public Lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getters and setters for external communication
	public long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(long lecturerId) {
		this.lecturerId = lecturerId;
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

	public ArrayList<Course> getTaughtCourses() {
		return taughtCourses;
	}

	public void setTaughtCourses(ArrayList<Course> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}
}
