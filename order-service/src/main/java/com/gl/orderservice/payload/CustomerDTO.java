package com.gl.orderservice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    int id;
    String name;
    String location;
    String contactNumber;
}
