package com.psvetic.partsunlimited.exceptions;

public class ModelNotFound extends RuntimeException {
    public ModelNotFound(Long id) {
        super("Model " + id + " does not exist.");
    }
}
