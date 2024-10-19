package com.gl.orderservice.controller;

import com.gl.orderservice.client.OpenFeignCustomer;
import com.gl.orderservice.client.OpenFeignProduct;
import com.gl.orderservice.entity.Order;
import com.gl.orderservice.exception.ResourceNotFoundException;
import com.gl.orderservice.payload.CustomerDTO;
import com.gl.orderservice.payload.OrderDTO;
import com.gl.orderservice.payload.ProductDTO;
import com.gl.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {
     OrderService orderService;
     OpenFeignCustomer openFeignCustomer;
     OpenFeignProduct openFeignProduct;

     @PostMapping
     public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
         // check the customer is valid or not
         CustomerDTO customerDTO = openFeignCustomer.getCustomerByContactNumber(orderDTO.getContactNumber());

         // check the product is valid or not
         ProductDTO productDTO = openFeignProduct.getProductById(orderDTO.getProductId());

         if(customerDTO!=null){
             if(productDTO!=null){
                 orderDTO.setProductAmount(productDTO.getPrice());
                 orderDTO.setShippingLocation(customerDTO.getLocation());

                 //quanity update in product table
                 productDTO.setQuantity(productDTO.getQuantity()-1);
                 openFeignProduct.updateProduct(productDTO);
             }
             else {
                 throw new ResourceNotFoundException("Product","Id",orderDTO.getProductId()+"");
             }
         }
         else {
             throw new ResourceNotFoundException("Customer","ContactNumber",orderDTO.getContactNumber());
         }
         OrderDTO orderDTO1 = orderService.createOrder(orderDTO);

         return new ResponseEntity<>(orderDTO1, HttpStatus.CREATED);
    }

    @DeleteMapping
     public OrderDTO cancelOrder(@RequestBody OrderDTO orderDTO) {
        CustomerDTO customerDTO = openFeignCustomer.getCustomerByContactNumber(orderDTO.getContactNumber());

        // check the product is valid or not
        ProductDTO productDTO = openFeignProduct.getProductById(orderDTO.getProductId());

        if(customerDTO!=null){
            if(productDTO!=null){

               OrderDTO orderDTO1 =  orderService.cancelOrder(orderDTO);
                //quanity update in product table
                productDTO.setQuantity(productDTO.getQuantity()+1);
                openFeignProduct.updateProduct(productDTO);

                return orderDTO1;

            }
            else {
                throw new ResourceNotFoundException("Product","Id",orderDTO.getProductId()+"");
            }
        }
        else {
            throw new ResourceNotFoundException("Customer","ContactNumber",orderDTO.getContactNumber());
        }
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable int id){
         return orderService.getOrder(id);
    }


}
