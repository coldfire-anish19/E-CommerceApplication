package com.gl.customerservice.service.impl;

import com.gl.customerservice.CustomerServiceApplication;
import com.gl.customerservice.entity.Customer;
import com.gl.customerservice.exception.ResourceNotFoundException;
import com.gl.customerservice.payload.CustomerDTO;
import com.gl.customerservice.repository.CustomerRepository;
import com.gl.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
         Customer savedCustomer = customerRepository.save(mapToEntity(customerDTO));
         return mapToDTO(savedCustomer);
    }

    @Override
    public CustomerDTO findByContactNumber(String contactNumber) {
        Customer customer = customerRepository.findByContactNumber(contactNumber);
        return mapToDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        customerRepository.findById(customerDTO.getId()).orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerDTO.getId()+""));
        customerRepository.save(mapToEntity(customerDTO));
        return customerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        return mapToDTO(customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","Id",id+"")));
    }

    @Override
    public CustomerDTO deleteCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","Id",id+""));
        customerRepository.delete(customer);
        return mapToDTO(customer);
    }


    public Customer mapToEntity(CustomerDTO customerDTO){
        return CustomerServiceApplication.mapper().map(customerDTO,Customer.class);
    }

    public CustomerDTO mapToDTO(Customer customer){
        return CustomerServiceApplication.mapper().map(customer,CustomerDTO.class);
    }

}
