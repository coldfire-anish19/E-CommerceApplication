package com.gl.orderservice.service;

import com.gl.orderservice.payload.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO cancelOrder(OrderDTO orderDTO);
    OrderDTO getOrder(int id);
}
