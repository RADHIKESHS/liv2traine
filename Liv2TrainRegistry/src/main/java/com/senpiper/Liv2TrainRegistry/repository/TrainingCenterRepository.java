package com.senpiper.Liv2TrainRegistry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senpiper.Liv2TrainRegistry.model.Address;
import com.senpiper.Liv2TrainRegistry.model.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    boolean existsByAddress(Address address);
}

