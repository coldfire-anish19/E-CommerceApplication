package com.gl.customerservice.controller;

import com.gl.customerservice.payload.CustomerDTO;
import com.gl.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    CustomerService customerService;
    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(customerDTO);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/contact/{contactNumber}")
    public CustomerDTO getCustomerByContactNumber(@PathVariable String contactNumber){
        return customerService.findByContactNumber(contactNumber);
    }

    @DeleteMapping("/{id}")
    public CustomerDTO deleteCustomerById(@PathVariable int id){
        return customerService.deleteCustomerById(id);
    }


}
