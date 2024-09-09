package com.senpiper.Liv2TrainRegistry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senpiper.Liv2TrainRegistry.exceptions.ResourceNotFoundException;
import com.senpiper.Liv2TrainRegistry.model.Address;
import com.senpiper.Liv2TrainRegistry.model.TrainingCenter;
import com.senpiper.Liv2TrainRegistry.repository.AddressRepository;
import com.senpiper.Liv2TrainRegistry.repository.TrainingCenterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {
	
	@Autowired
    private TrainingCenterRepository trainingCenterRepository;
	
	@Autowired
    private AddressRepository addressRepository;

	/**
	 * Creates a new TrainingCenter and saves it to the database.
	 * If the address already exists, it will be reused.
	 */
    @Override
    @Transactional
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        Address address = trainingCenter.getAddress();
        Optional<Address> existingAddress = addressRepository.findByDetailedAddressAndCityAndStateAndPincode(
                address.getDetailedAddress(), address.getCity(), address.getState(), address.getPincode());

        if (existingAddress.isPresent()) {
            trainingCenter.setAddress(existingAddress.get());
        } else {
            addressRepository.save(address);
        }

        return trainingCenterRepository.save(trainingCenter);
    }
    
    
    // Get all the saved TrainingCenter
    @Override
    public List<TrainingCenter> getAllTrainingCenters() {
        if(trainingCenterRepository.findAll()==null) {
        	throw new ResourceNotFoundException("Training center Unavailable");
        }else {   			
        	return trainingCenterRepository.findAll();
        }
    }

    @Override
    @Transactional
    public void deleteTrainingCenter(Long id) {
        TrainingCenter center = trainingCenterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TrainingCenter not found"));
        Address address = center.getAddress();
        
        // Delete the training center from the repository
        trainingCenterRepository.delete(center);

        // Check if the address is still referenced by any other training center
        if (!trainingCenterRepository.existsByAddress(address)) {
            // If not, delete the address
            addressRepository.delete(address);
        }
    }

}

