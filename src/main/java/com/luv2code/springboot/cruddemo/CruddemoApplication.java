package com.luv2code.springboot.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.springboot.cruddemo.dao.AppDAO;
import com.luv2code.springboot.cruddemo.entity.Instructor;
import com.luv2code.springboot.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);

			// findInstructorById(appDAO);

			// deleteInstructorById(appDAO);

			// findInstructorDetailById(appDAO);

			deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// delete the instructor detail by primary key / id
		int theId = 2;
		System.out.println("Deleting instructor detail with id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// get the instructor detail by primary key / id
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Found instructor detail: " + tempInstructorDetail);
		System.out.println("Instructor: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// delete the instructor by primary key / id
		int theId = 1;
		System.out.println("Deleting instructor with id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructorById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// get the instructor by primary key / id
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("InstructorDetails: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// create the instructor
		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
		// create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);
		// save the instructor
		System.out.println("Saving instructor: " + instructor);

		// Note: this will ALSO save the details object because of CascadeType.ALL
		// because of CascadeType.ALL

		appDAO.save(instructor);
	}

}
