package com.gl.productservice.payload;

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
