package com.senpiper.Liv2TrainRegistry.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a training center with details including its name, courses offered, and addresses.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String centerName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "CenterCode must be exactly 12 alphanumeric characters")
    private String centerCode;

    
//    Address associated with the training center.
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Integer studentCapacity;


//     List of courses stored in a separate table due to @ElementCollection mapping.
    @ElementCollection
    @CollectionTable(name = "training_center_courses", joinColumns = @JoinColumn(name = "training_center_id"))
    @Column(name = "course_name")
    private List<String> coursesOffered = new ArrayList<>();

    private Long createdOn;

    @Email
    private String contactEmail;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        this.createdOn = System.currentTimeMillis() / 1000;
    }

}
