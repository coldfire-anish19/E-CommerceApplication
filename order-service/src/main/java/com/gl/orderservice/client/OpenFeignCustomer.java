package com.gl.orderservice.client;

import com.gl.orderservice.payload.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface OpenFeignCustomer {

    @GetMapping("/api/customers/contact/{contactNumber}")
    CustomerDTO getCustomerByContactNumber(@PathVariable String contactNumber);


}
