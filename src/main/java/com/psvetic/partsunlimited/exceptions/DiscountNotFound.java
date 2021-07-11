package com.psvetic.partsunlimited.exceptions;

public class DiscountNotFound extends RuntimeException {
    public DiscountNotFound(Long id) {
        super("Discount " + id + " does not exist.");
    }
}
