package com.senpiper.Liv2TrainRegistry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senpiper.Liv2TrainRegistry.model.TrainingCenter;
import com.senpiper.Liv2TrainRegistry.service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TrainingCenterController {
	
	@Autowired
    private TrainingCenterService trainingCenterService;

    /**
     * Creates a new Training Center and saves it to the database.
     * 
     * Required Fields:
     * - centerName (text, required, max length: 40 characters)
     * - centerCode (text, required, exactly 12 alphanumeric characters)
     * - address (object, required)
     *   - detailedAddress (text, required)
     *   - city (text, required)
     *   - state (text, required)
     *   - pincode (text, required, 6-digit number)
     * - studentCapacity (number, optional)
     * - coursesOffered (List of text, optional)
     * - contactEmail (text, optional, valid email format if present)
     * - contactPhone (text, required, valid phone number format)
     * 
     * @param trainingCenter The training center data to be created.
     * @param result BindingResult to hold validation errors.
     * @return ResponseEntity containing the newly created TrainingCenter and HTTP status code.
     * @throws MethodArgumentNotValidException If validation fails.
     */
    @PostMapping("/getall-training-centers")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter createdCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCenter);
    }

    /**
     * Retrieves a list of all training centers.
     */
    @GetMapping("/add-training-center")
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(centers);
    }
}

