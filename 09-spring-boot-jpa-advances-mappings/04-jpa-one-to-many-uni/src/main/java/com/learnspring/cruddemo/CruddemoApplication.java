package com.learnspring.cruddemo;

import com.learnspring.cruddemo.dao.AppDAO;
import com.learnspring.cruddemo.entity.Course;
import com.learnspring.cruddemo.entity.Instructor;
import com.learnspring.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourseById(theId);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course id: " + theId);

		tempCourse.setTitle("TESTER");

		appDAO.update(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Update data for instructor: " + theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);
	}

	private void findCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdByJoinFetch(theId);

		System.out.println("tempInstructor " + tempInstructor);
		System.out.println("Associated courses: " + tempInstructor.getCourses());

		System.out.println("done!");
	}

	private void findCourcesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);

		List<Course> courses = appDAO.findCourseByInstructorId(theId);
		tempInstructor.setCourses(courses);

		System.out.println("Associated courses: " + tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associated courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Jimmy", "Hendricks" , "qqq@qwe.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/jimmy", "music");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course tempCourse1 = new Course("Air guitar");
		Course tempCourse2 = new Course("ball");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("saving instructor " + tempInstructor);
		System.out.println("The course: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor details id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		System.out.println("Associated Instructor: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Instructor deleted id: " + theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructor detail " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
        /*
		Instructor tempInstructor = new Instructor("Chad", "Darby" , "qqq@qwe.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "eat");
		*/

		Instructor tempInstructor = new Instructor("Bhau", "Kadam" , "qqq@qwe.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/bhau", "Joke");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor" + tempInstructor);
		appDAO.save(tempInstructor);
	}

}
