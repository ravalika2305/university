package com.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String courseName;
	public int duration;
	
	@ManyToOne
	@JoinColumn(name = "university_id")
	private UniversityEntity university;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public UniversityEntity getUniversity() {
		return university;
	}

	public void setUniversity(UniversityEntity university) {
		this.university = university;
	}

	public CourseEntity(long id, String courseName, int duration, UniversityEntity university) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.duration = duration;
		this.university = university;
	}

	public CourseEntity() {
		super();
	}

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", courseName=" + courseName + ", duration=" + duration + ", university="
				+ university + "]";
	}

	
}
