package com.gl.productservice.service.impl;

import com.gl.productservice.entity.Product;
import com.gl.productservice.exception.ResourceNotFoundException;
import com.gl.productservice.payload.ProductDTO;
import com.gl.productservice.repository.ProductRepository;
import com.gl.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ModelMapper modelMapper;

//    @Value("${server.port}")
//    private String portNum;
    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        return mapToDTO(productRepository.save(mapToEntity(productDTO)));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        productRepository.findById(productDTO.getId()).orElseThrow(()->new ResourceNotFoundException("Product ","ID",productDTO.getId()+""));
        productRepository.save(mapToEntity(productDTO));
      //  System.out.println("Server Port: "+portNum);
        return productDTO;
    }

    @Override
    public ProductDTO getProductById(int id) {
        //System.out.println("Server Port: "+portNum);
        return mapToDTO(productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product ","Id",id+"")));
    }

    @Override
    public ProductDTO deleteProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product ","Id",id+""));
        productRepository.delete(product);
      //  System.out.println("Server Port: "+portNum);
        return mapToDTO(product);
    }

    public ProductDTO mapToDTO(Product product){
        return modelMapper.map(product,ProductDTO.class);
    }

    public Product mapToEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO,Product.class);
    }
}

