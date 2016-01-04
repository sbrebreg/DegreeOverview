package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import model.Course;

@Path("courses")
// Connection to Agility Persistence plugin
public class CourseService {
	private static ArrayList<Course> courseList = new ArrayList<Course>();

	@PUT //Edit data (ID is transmitted)
	@Path("{id:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Course update(@PathParam("id") Long id,
			MultivaluedMap<String, String> params) {
		
		System.out.println("update");
		
		Course course = new Course(params.getFirst("title"),
				params.getFirst("ects"), params.getFirst("examType"), 
				params.getFirst("content"), 
				params.getFirst("learningOutcomes"), 
				params.getFirst("requiredCourses"), 
				params.getFirst("recommendedCourses"), 
				params.getFirst("lecturer"), 
				params.getFirst("day"), 
				params.getFirst("timeSlot"), 
				params.getFirst("location"), 
				params.getFirst("taught"), 
				params.getFirst("joined"), 
				params.getFirst("passed"), 
				params.getFirst("result"));
		course.setId(id);
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			if (c.getId() == course.getId()) {
				courseList.set(i, course); //update
				break;
			}
		}
		return course;
	}

	@POST
	// Add data (if no ID is transmitted -> new course)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Course create(MultivaluedMap<String, String> params) {

		System.out.println("create");

		Course course = new Course(params.getFirst("title"),
				params.getFirst("ects"), params.getFirst("examType"), 
				params.getFirst("content"), 
				params.getFirst("learningOutcomes"), 
				params.getFirst("requiredCourses"), 
				params.getFirst("recommendedCourses"), 
				params.getFirst("lecturer"), 
				params.getFirst("day"), 
				params.getFirst("timeSlot"), 
				params.getFirst("location"), 
				params.getFirst("taught"), 
				params.getFirst("joined"), 
				params.getFirst("passed"), 
				params.getFirst("result"));

		// Simulation of the Id, will be generated later by DB
		long maxId = 0;
		for (Course currentCourse : courseList) {
			if (maxId < currentCourse.getId()) {
				maxId = currentCourse.getId();
			}
		}
		course.setId(maxId + 1);

		courseList.add(course);
		return course;
	}

	@GET
	// Read data: single course
	@Path("{id:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course load(@PathParam("id") Long id) {
		System.out.println("load");
		Course course = null; // new object of Course, empty
		for (Course c : courseList) {
			if (c.getId() == id) {
				course = c;
			}
		}
		return course;
	}

	@GET
	// Read data: courseList
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Course> getAll() {
		System.out.println("getAll");
		return courseList;
	}

	@DELETE
	// Delete data
	@Path("{id:[0-9]*}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("delete");
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			if (c.getId() == id) {
				courseList.remove(i);
				break;
			}
		}
	}

}
