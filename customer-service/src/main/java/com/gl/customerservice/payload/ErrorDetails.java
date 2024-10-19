package com.gl.customerservice.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String description;

    public ErrorDetails(Date timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
