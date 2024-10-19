package com.gl.productservice.controller;

import com.gl.productservice.payload.ProductDTO;
import com.gl.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    ProductService productService;

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    //To be Called By only Customer Microservice
    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    public ProductDTO deleteProductById(@PathVariable int id){
        return productService.deleteProductById(id);
    }

}
