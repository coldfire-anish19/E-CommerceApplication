package com.gl.productservice.service;

import com.gl.productservice.payload.ProductDTO;

public interface ProductService {

    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    ProductDTO getProductById(int id);
    ProductDTO deleteProductById(int id);
}
