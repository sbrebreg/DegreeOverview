package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Course;

@Stateless
public class CourseSessionBean {
	@PersistenceContext(unitName="COURSES")
	private EntityManager em;
	
	//Method saving course
	public Course createCourse(Course c) { //uses model Course
		em.persist(c);
		return c;
	}
	
	//Method editing course?
	public Course updateCourse(Long id) { //uses model Course
		em.merge(id);
		//return (Course.class, id);
		return em.find(Course.class, id); //?
	}
	
	//Method deleting course?
	public Course deleteCourse(Long id) { //uses model Course
		em.remove(id);
		return em.find(Course.class, id);//?
	}

	//Method loading course
	public Course findCourse(Long id) {
		return em.find(Course.class, id);
		}
	
	//Method loading list of courses
	public List<Course> findCourses() {
		
		List<Course> courses = null; //List from database will be saved in variable courses
		Query q = em.createQuery("SELECT c FROM COURSES c");
		courses = q.getResultList();
		return courses;
		
		//return em.find(Course.class, id);
	}

}
