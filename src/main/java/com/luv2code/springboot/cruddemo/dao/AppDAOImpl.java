package com.luv2code.springboot.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Instructor;
import com.luv2code.springboot.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO {

  // define field for entity manager
  private EntityManager entityManager;

  // inject entity manager using constructor injection

  @Autowired
  public AppDAOImpl(EntityManager theEntityManager) {
    this.entityManager = theEntityManager;
  }

  @Override
  @Transactional
  public void save(Instructor instructor) {
    entityManager.persist(instructor);
  }

  @Override
  public Instructor findInstructorById(int id) {
    return entityManager.find(Instructor.class, id);
  }

  @Override
  @Transactional
  public void deleteInstructorById(int id) {
    // retrive the instructor
    Instructor instructor = findInstructorById(id);
    // delete the instructor
    entityManager.remove(instructor);
  }

  @Override
  public InstructorDetail findInstructorDetailById(int id) {
    return entityManager.find(InstructorDetail.class, id);
  }

  @Override
  @Transactional
  public void deleteInstructorDetailById(int id) {
    // retrive the instructor detail
    InstructorDetail instructorDetail = findInstructorDetailById(id);
    // remove the associated object reference
    // break bi-directional link
    instructorDetail.getInstructor().setInstructorDetail(null);
    // delete the instructor detailins
    entityManager.remove(instructorDetail);
  }

}
