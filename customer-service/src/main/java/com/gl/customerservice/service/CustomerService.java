package com.gl.customerservice.service;

import com.gl.customerservice.payload.CustomerDTO;

public interface CustomerService {

    CustomerDTO addCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(int id);

    CustomerDTO deleteCustomerById(int id);
    CustomerDTO findByContactNumber(String contactNumber);
}
