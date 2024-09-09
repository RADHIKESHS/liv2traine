package com.senpiper.Liv2TrainRegistry.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senpiper.Liv2TrainRegistry.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByDetailedAddressAndCityAndStateAndPincode(String detailedAddress, String city, String state, String pincode);
}

