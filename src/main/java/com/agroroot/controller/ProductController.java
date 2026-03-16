package com.agroroot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.agroroot.model.Product;
import com.agroroot.model.Farmer;
import com.agroroot.repository.FarmerRepository;
import com.agroroot.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FarmerRepository farmerRepository;

    @PostMapping("/{farmerId}")
    public Product addProduct(@PathVariable Long farmerId,
                              @RequestBody Product product){

        Farmer farmer = farmerRepository.findById(farmerId).orElse(null);

        product.setFarmer(farmer);

        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
}