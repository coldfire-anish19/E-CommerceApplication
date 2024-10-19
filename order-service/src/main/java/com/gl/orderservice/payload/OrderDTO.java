package com.gl.orderservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderDTO {
    private int id;
    private int productId;
    private int productAmount;
    private String shippingLocation;
    private String contactNumber;
}
