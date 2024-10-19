package com.gl.orderservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(resourceName+" having "+fieldName+": "+fieldValue+"is not found");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
