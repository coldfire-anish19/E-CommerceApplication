package com.gl.orderservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private int quantity;
}
