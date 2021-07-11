package com.psvetic.partsunlimited.exceptions;

public class PartNotFound extends RuntimeException {
    public PartNotFound(Long id) {
        super("Part " + id + " does not exist.");
    }
}
