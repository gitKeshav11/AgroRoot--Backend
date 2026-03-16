package com.agroroot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.agroroot.model.Farmer;
import com.agroroot.repository.FarmerRepository;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public Farmer saveFarmer(Farmer farmer){
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAllFarmers(){
        return farmerRepository.findAll();
    }
}