package com.university.Service;

import com.university.entity.UniversityEntity;
import com.university.exceptions.ResourceNotFoundException;
import com.university.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public UniversityEntity saveUniversity(UniversityEntity university) {
        return universityRepository.save(university);
    }

    public List<UniversityEntity> getAllUniversities() {
        return universityRepository.findAll();
    }

    public UniversityEntity getUniversityById(Long id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University not found with ID: " + id));
    }

    public UniversityEntity updateUniversity(Long id, UniversityEntity universityDetails) {
        return universityRepository.findById(id).map(university -> {
            if (universityDetails.getName() != null) {
                university.setName(universityDetails.getName());
            }
            if (universityDetails.getLocation() != null) {
                university.setLocation(universityDetails.getLocation());
            }
            return universityRepository.save(university);
        }).orElseThrow(() -> new ResourceNotFoundException("University not found with ID: " + id));
    }

    public void deleteUniversity(Long id) {
        if (!universityRepository.existsById(id)) {
            throw new ResourceNotFoundException("University not found with ID: " + id);
        }
        universityRepository.deleteById(id);
    }
}
