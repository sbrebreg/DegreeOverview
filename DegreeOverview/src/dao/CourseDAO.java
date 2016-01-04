package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Course;

public class CourseDAO {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("CourseDB"); //Assigning an Entity Manager (JPA)
	
	//Method saving course
	public void save(Course course) throws Exception { //uses model Course
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin(); //transaction begins
			em.persist(course);
			tx.commit(); //if successful: Commit
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //if unsuccessful: Rollback
			throw e;
		}
	}
	
	//Method editing course
	public void update(Course course) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(course);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
	}
	
	//Method deleting course
	public void delete(long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Course.class, id));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
	}

	//Method loading course
	public Course load(long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Course course = null;
		try {
			tx.begin();
			course = em.find(Course.class, id); //Loading an object from database
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
		return course;
	}
	
	//Method loading list of courses
	public List<Course> getAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Course> courses = null; //List from database will be saved in variable courses
		try {
			tx.begin();
			Query q = em.createQuery("SELECT c FROM COURSES c");
			courses = q.getResultList();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
		return courses;
	}

}
