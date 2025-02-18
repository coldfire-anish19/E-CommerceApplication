package com.gl.productservice.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    Date dateStamp;
    String message;
    String description;
}
