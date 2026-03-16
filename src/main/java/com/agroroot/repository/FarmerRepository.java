package com.agroroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agroroot.model.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}