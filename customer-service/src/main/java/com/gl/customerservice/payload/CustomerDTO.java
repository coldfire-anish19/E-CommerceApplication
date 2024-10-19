package com.gl.customerservice.payload;

import jakarta.persistence.Column;
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
