package com.psvetic.partsunlimited.exceptions;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(Long id) {
        super("Product " + id + " does not exist.");
    }
}
