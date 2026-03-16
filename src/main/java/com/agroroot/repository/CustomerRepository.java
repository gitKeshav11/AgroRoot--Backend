package com.agroroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agroroot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}