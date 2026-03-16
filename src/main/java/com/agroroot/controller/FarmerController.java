package com.agroroot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.agroroot.model.Farmer;
import com.agroroot.model.Product;
import com.agroroot.repository.FarmerRepository;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    @Autowired
    private FarmerRepository farmerRepository;

    @PostMapping
    public Farmer createFarmer(@RequestBody Farmer farmer){
        return farmerRepository.save(farmer);
    }

    @GetMapping
    public List<Farmer> getFarmers(){
        return farmerRepository.findAll();
    }

    @GetMapping("/{id}/products")
    public List<Product> getFarmerProducts(@PathVariable Long id){

        Farmer farmer = farmerRepository.findById(id).orElse(null);

        return farmer.getProducts();
    }
}