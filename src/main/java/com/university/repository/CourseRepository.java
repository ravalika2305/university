package com.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{

}
