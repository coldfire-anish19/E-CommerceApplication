package com.gl.orderservice.service.impl;


import com.gl.orderservice.client.OpenFeignCustomer;
import com.gl.orderservice.client.OpenFeignProduct;
import com.gl.orderservice.entity.Order;
import com.gl.orderservice.exception.ResourceNotFoundException;
import com.gl.orderservice.payload.CustomerDTO;
import com.gl.orderservice.payload.OrderDTO;
import com.gl.orderservice.payload.ProductDTO;
import com.gl.orderservice.repository.OrderRepository;
import com.gl.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapper modelMapper;
    private OpenFeignCustomer openFeignCustomer;
    private OpenFeignProduct openFeignProduct;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        return mapToDTO(orderRepository.save(mapToEntity(orderDTO)));
    }

    @Override
    public OrderDTO cancelOrder(OrderDTO orderDTO) {
        // check the customer is valid or not
        Order order = orderRepository.findByContactNumberAndProductId(orderDTO.getContactNumber(), orderDTO.getProductId());
        if (order == null){
            throw new ResourceNotFoundException("Order","ContactNumber & Product Id", order.getContactNumber()+" & "+order.getProductId());
        }

        orderRepository.delete(order);
        return mapToDTO(order);
    }

    @Override
    public OrderDTO getOrder(int id) {
        Order order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","Id",id+""));
        return mapToDTO(order);
    }

    public OrderDTO mapToDTO(Order order){
        return modelMapper.map(order,OrderDTO.class);
    }
    public Order mapToEntity(OrderDTO orderDTO){
        return modelMapper.map(orderDTO,Order.class);
    }
}
