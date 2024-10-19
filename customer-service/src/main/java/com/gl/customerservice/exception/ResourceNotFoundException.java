package com.gl.customerservice.exception;

public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(resourceName+"having "+fieldName+": "+fieldValue+" is not found");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
