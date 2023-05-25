package com.acme.university.model;

import java.util.Date;
import java.util.List;


public class Student extends BaseModel {
	private String name;
	private String address;
	private Date dateOfBirth;
	private List<Enrollment> enrollments;

	public Student(final Long id, final String name, final String address, final Date dateOfBirth) {
		super(id);
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public Student(String name, String address, Date dateOfBirth) {
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public Student(String name, String address, Date dateOfBirth, List<Enrollment> enrollments) {
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.enrollments = enrollments;
	}

	public Student(final Long id, final String name, final String address, final Date dateOfBirth,
				   final String telephoneNumber, final List<Enrollment> enrollments) {
		super(id);
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.enrollments = enrollments;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(final List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", enrollments=" + enrollments +
				"} " + super.toString();
	}
}
