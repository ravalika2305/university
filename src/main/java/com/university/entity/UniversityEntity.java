package com.university.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UniversityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String location;
    
	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourseEntity> courses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<CourseEntity> getCourseentity() {
		return courses;
	}

	public void setCourseentity(List<CourseEntity> courseentity) {
		this.courses = courseentity;
	}

	public UniversityEntity(Long id, String name, String location, List<CourseEntity> courseentity) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.courses = courseentity;
	}

	public UniversityEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UniversityEntity [id=" + id + ", name=" + name + ", location=" + location + ", courseentity="
				+ courses + "]";
	}
	
	
}
