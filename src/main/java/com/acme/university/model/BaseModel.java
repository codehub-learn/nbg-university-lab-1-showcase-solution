package com.acme.university.model;

public abstract class BaseModel {
	private Long id;

	protected BaseModel(final Long id) {
		this.id = id;
	}

	protected BaseModel() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BaseModel{" + "id=" + id + '}';
	}
}
