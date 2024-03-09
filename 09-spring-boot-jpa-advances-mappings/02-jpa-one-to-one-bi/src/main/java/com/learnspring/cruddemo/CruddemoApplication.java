package com.learnspring.cruddemo;

import com.learnspring.cruddemo.dao.AppDAO;
import com.learnspring.cruddemo.entity.Instructor;
import com.learnspring.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
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
