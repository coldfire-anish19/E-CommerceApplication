package com.gl.customerservice.repository;

import com.gl.customerservice.entity.Customer;
import com.gl.customerservice.payload.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByContactNumber(String contactNumber);
}
