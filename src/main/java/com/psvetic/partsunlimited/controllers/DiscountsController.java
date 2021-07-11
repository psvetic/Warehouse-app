package com.psvetic.partsunlimited.controllers;

import com.psvetic.partsunlimited.models.Discount;
import com.psvetic.partsunlimited.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountsController {

    @Autowired
    private DiscountRepository discountRepository;

    @GetMapping
    public List<Discount> getDiscounts() {
        return discountRepository.findAll();
    }

    @PostMapping
    public Discount createDiscount(@RequestBody Discount discount) {
        return discountRepository.saveAndFlush(discount);
    }
}
