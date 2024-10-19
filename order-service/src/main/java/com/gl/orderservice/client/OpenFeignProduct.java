package com.gl.orderservice.client;

import com.gl.orderservice.payload.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PRODUCT-SERVICE")
public interface OpenFeignProduct {
    @GetMapping("api/products/{id}")
    public ProductDTO getProductById(@PathVariable int id);
    @PutMapping("api/products")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO);
}
