package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Configuring O/R-Mapping via notations
@Entity(name="RESULTS") //Name of the database
public class Result {
	
	//Attributes
	@Id @GeneratedValue //Configuring primary key (= id)
	private long resultId;
	private long courseId; //necessary?
	private String semester; //lecturers only?
	private String singleGrades; //students only?
	private String aggregatedGrades; //lecturers only?
	private String averageMean; //lecturers and students?
	private String averageMedian; //lecturers only?

	
	//Constructors
	public Result(long courseId, String semester, String singleGrades,
			String aggregatedGrades, String averageMean, String averageMedian) {
		super();
		this.courseId = courseId;
		this.semester = semester;
		this.singleGrades = singleGrades;
		this.aggregatedGrades = aggregatedGrades;
		this.averageMean = averageMean;
		this.averageMedian = averageMedian;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getters and setters for external communication
	public long getResultId() {
		return resultId;
	}

	public void setResultId(long resultId) {
		this.resultId = resultId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSingleGrades() {
		return singleGrades;
	}

	public void setSingleGrades(String singleGrades) {
		this.singleGrades = singleGrades;
	}

	public String getAggregatedGrades() {
		return aggregatedGrades;
	}

	public void setAggregatedGrades(String aggregatedGrades) {
		this.aggregatedGrades = aggregatedGrades;
	}

	public String getAverageMean() {
		return averageMean;
	}

	public void setAverageMean(String averageMean) {
		this.averageMean = averageMean;
	}

	public String getAverageMedian() {
		return averageMedian;
	}

	public void setAverageMedian(String averageMedian) {
		this.averageMedian = averageMedian;
	}
	
}
