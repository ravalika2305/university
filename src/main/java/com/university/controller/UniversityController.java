package com.university.controller;

import com.university.Service.UniversityService;
import com.university.entity.UniversityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping
    public ResponseEntity<UniversityEntity> createUniversity(@RequestBody UniversityEntity university) {
        return ResponseEntity.ok(universityService.saveUniversity(university));
    }

    @GetMapping
    public ResponseEntity<List<UniversityEntity>> getAllUniversities() {
        return ResponseEntity.ok(universityService.getAllUniversities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityEntity> getUniversityById(@PathVariable Long id) {
        return ResponseEntity.ok(universityService.getUniversityById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityEntity> updateUniversity(@PathVariable Long id, @RequestBody UniversityEntity universityDetails) {
        UniversityEntity updatedUniversity = universityService.updateUniversity(id, universityDetails);
        return ResponseEntity.ok(updatedUniversity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.ok("University deleted successfully");
    }
}
