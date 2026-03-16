package com.agroroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agroroot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}