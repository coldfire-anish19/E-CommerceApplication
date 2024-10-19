package com.gl.orderservice.repository;

import com.gl.orderservice.entity.Order;
import com.gl.orderservice.payload.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

     List<Order> findByContactNumber(String contactNumber);

     Order findByContactNumberAndProductId(String contactNumber, int productId);
}
