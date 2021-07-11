package com.psvetic.partsunlimited.models;

import java.time.LocalDate;

public interface ProductWithDiscount {

    public Long getSerialNumber();
    public String getProductName();
    public LocalDate getManufactureDate();
    public float getPrice();
}
