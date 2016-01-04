package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Configuring O/R-Mapping via notations
@Entity(name="COURSES") //Name of the database
public class Course {
	
	//Attributes
	@Id @GeneratedValue //Configuring primary key (= id)
	/* General course info */
	private long courseId;
	private String title;
	private String ects;
	private String examType;
	private String content;
	private String learningOutcomes; //necessary?
	private String requiredCourses; //necessary?
	private String recommendedCourses;
	private Lecturer lecturerId;
	
	/* Timetable info */
	private String day;
	private String timeSlot;
	private String location;
	
	/* Student and lecturer related info */
	private boolean taught; //Necessary here? Or just DB-operation?
	private boolean joined; //Necessary here? Or just DB-operation?
	private boolean passed; //Necessary here? Or just DB-operation?
	private Result result;
	
	
	//Constructors
	public Course(String title, String ects, String examType, String content,
			String learningOutcomes, String requiredCourses,
			String recommendedCourses, Lecturer lecturerId, String day,
			String timeSlot, String location, boolean taught, boolean joined,
			boolean passed, Result result) {
		super();
		this.title = title;
		this.ects = ects;
		this.examType = examType;
		this.content = content;
		this.learningOutcomes = learningOutcomes;
		this.requiredCourses = requiredCourses;
		this.recommendedCourses = recommendedCourses;
		this.lecturerId = lecturerId;
		this.day = day;
		this.timeSlot = timeSlot;
		this.location = location;
		this.taught = taught;
		this.joined = joined;
		this.passed = passed;
		this.result = result;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Getters and setters for external communication
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEcts() {
		return ects;
	}

	public void setEcts(String ects) {
		this.ects = ects;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLearningOutcomes() {
		return learningOutcomes;
	}

	public void setLearningOutcomes(String learningOutcomes) {
		this.learningOutcomes = learningOutcomes;
	}

	public String getRequiredCourses() {
		return requiredCourses;
	}

	public void setRequiredCourses(String requiredCourses) {
		this.requiredCourses = requiredCourses;
	}

	public String getRecommendedCourses() {
		return recommendedCourses;
	}

	public void setRecommendedCourses(String recommendedCourses) {
		this.recommendedCourses = recommendedCourses;
	}

	public Lecturer getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Lecturer lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isTaught() {
		return taught;
	}

	public void setTaught(boolean taught) {
		this.taught = taught;
	}

	public boolean isJoined() {
		return joined;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
}
