package com.acme.university.model;

public class Unit extends BaseModel {
	private String name;
	private String tutorName;

	public Unit(String name, String tutorName) {
		this.name = name;
		this.tutorName = tutorName;
	}

	public Unit(final Long id, final String name, final String tutorName) {
		super(id);
		this.name = name;
		this.tutorName = tutorName;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(final String tutorName) {
		this.tutorName = tutorName;
	}

	@Override
	public String toString() {
		return "Unit{" +
				"name='" + name + '\'' +
				", tutorName='" + tutorName + '\'' +
				"} " + super.toString();
	}
}
