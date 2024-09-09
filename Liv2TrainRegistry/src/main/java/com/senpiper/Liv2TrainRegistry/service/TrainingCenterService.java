package com.senpiper.Liv2TrainRegistry.service;

import java.util.List;

import com.senpiper.Liv2TrainRegistry.model.TrainingCenter;

public interface TrainingCenterService {

    TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);

    List<TrainingCenter> getAllTrainingCenters();

    void deleteTrainingCenter(Long id);
}

