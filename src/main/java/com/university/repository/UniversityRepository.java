package com.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.entity.UniversityEntity;

public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {

}
