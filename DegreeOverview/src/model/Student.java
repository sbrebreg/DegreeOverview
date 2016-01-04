package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Configuring O/R-Mapping via notations
@Entity(name="STUDENTS") //Name of the database
public class Student extends User {
	
	//Attributes
	@Id @GeneratedValue //Configuring primary key (= id)
	private long studentId;
	private String firstName;
	private String lastName;
	private String email;
	private String immaNr;
	private String studyProgram;
	private int targetedEcts;
	private int pendingEcts;
	private int achievedEcts;
	private ArrayList<Course> joinedCourses = new ArrayList<Course>();
	private ArrayList<Course> passedCourses = new ArrayList<Course>();
	private ArrayList<Result> results = new ArrayList<Result>(); //single grads and averageMean only
	
	//Constructors
	public Student(long id, String userType, String firstName, String lastName,
			String email, String university, long studentId, String firstName2,
			String lastName2, String email2, String immaNr,
			String studyProgram, int targetedEcts, int pendingEcts,
			int achievedEcts, ArrayList<Course> joinedCourses,
			ArrayList<Course> passedCourses, ArrayList<Result> results) {
		super(id, userType, firstName, lastName, email, university);
		this.studentId = studentId;
		firstName = firstName2;
		lastName = lastName2;
		email = email2;
		this.immaNr = immaNr;
		this.studyProgram = studyProgram;
		this.targetedEcts = targetedEcts;
		this.pendingEcts = pendingEcts;
		this.achievedEcts = achievedEcts;
		this.joinedCourses = joinedCourses;
		this.passedCourses = passedCourses;
		this.results = results;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getters and setters for external communication
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
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

	public String getImmaNr() {
		return immaNr;
	}

	public void setImmaNr(String immaNr) {
		this.immaNr = immaNr;
	}

	public String getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(String studyProgram) {
		this.studyProgram = studyProgram;
	}

	public int getTargetedEcts() {
		return targetedEcts;
	}

	public void setTargetedEcts(int targetedEcts) {
		this.targetedEcts = targetedEcts;
	}

	public int getPendingEcts() {
		return pendingEcts;
	}

	public void setPendingEcts(int pendingEcts) {
		this.pendingEcts = pendingEcts;
	}

	public int getAchievedEcts() {
		return achievedEcts;
	}

	public void setAchievedEcts(int achievedEcts) {
		this.achievedEcts = achievedEcts;
	}

	public ArrayList<Course> getJoinedCourses() {
		return joinedCourses;
	}

	public void setJoinedCourses(ArrayList<Course> joinedCourses) {
		this.joinedCourses = joinedCourses;
	}

	public ArrayList<Course> getPassedCourses() {
		return passedCourses;
	}

	public void setPassedCourses(ArrayList<Course> passedCourses) {
		this.passedCourses = passedCourses;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

}
