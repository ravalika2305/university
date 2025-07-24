package com.university.Service;

import com.university.entity.CourseEntity;
import com.university.entity.UniversityEntity;
import com.university.exceptions.InvalidRequestException;
import com.university.exceptions.ResourceNotFoundException;
import com.university.repository.CourseRepository;
import com.university.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UniversityRepository universityRepository;

    public CourseEntity saveCourse(CourseEntity course) {
        if (course.getUniversity() == null || course.getUniversity().getId() == null) {
            throw new InvalidRequestException("University ID is required to create a course.");
        }

        Optional<UniversityEntity> university = universityRepository.findById(course.getUniversity().getId());
        if (university.isEmpty()) {
            throw new ResourceNotFoundException("University with ID " + course.getUniversity().getId() + " not found.");
        }

        return courseRepository.save(course);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseEntity getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
    }

    public CourseEntity updateCourse(Long id, CourseEntity courseDetails) {
        return courseRepository.findById(id).map(course -> {
            if (courseDetails.getCourseName() != null) {
                course.setCourseName(courseDetails.getCourseName());
            }
            if (courseDetails.getDuration() > 0) {
                course.setDuration(courseDetails.getDuration());
            }
            if (courseDetails.getUniversity() != null && courseDetails.getUniversity().getId() != null) {
                Optional<UniversityEntity> university = universityRepository.findById(courseDetails.getUniversity().getId());
                if (university.isPresent()) {
                    course.setUniversity(university.get());
                } else {
                    throw new ResourceNotFoundException("University with given ID does not exist.");
                }
            }
            return courseRepository.save(course);
        }).orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }
}
