package com.luv2code.demo.entity;

/**
 * Student
 */
public class Student {

  private String firstName;
  private String lastName;

  // No-arg constructor
  public Student() {
  }

  // Constructor with args
  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Getters and Setters
  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}