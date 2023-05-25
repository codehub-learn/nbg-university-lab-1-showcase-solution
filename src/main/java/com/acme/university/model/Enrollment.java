package com.acme.university.model;

public class Enrollment extends BaseModel {
	private Unit unit;
	private int grade;

	public Enrollment(final Long id, final Unit unit, final int grade) {
		super(id);
		this.unit = unit;
		this.grade = grade;
	}

	public Enrollment(Unit unit, int grade) {
		this.unit = unit;
		this.grade = grade;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(final Unit unit) {
		this.unit = unit;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(final int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Enrollment{" +
				"unit=" + unit +
				", grade=" + grade +
				"} " + super.toString();
	}

}
