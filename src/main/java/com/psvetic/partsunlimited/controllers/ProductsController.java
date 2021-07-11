package com.psvetic.partsunlimited.controllers;

import com.psvetic.partsunlimited.exceptions.DiscountNotFound;
import com.psvetic.partsunlimited.exceptions.ProductNotFound;
import com.psvetic.partsunlimited.models.*;
import com.psvetic.partsunlimited.repositories.DiscountRepository;
import com.psvetic.partsunlimited.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @GetMapping
    public List<ProductWithDiscount> list() {
        return productRepository.displayProductInfo();
    }

    @PostMapping
    public Product create(@RequestBody final Product product) {
        return productRepository.saveAndFlush(product);
    }

    @PatchMapping
    public String updatePrice(@RequestParam Long id, @RequestBody float price) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));
        product.setBasePrice(price);
        productRepository.save(product);
        return "Successfully updated!";
    }

    @PutMapping
    public String updateDiscounts(@RequestParam Long id, @RequestBody Long IDDiscount) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));
        Discount discount = discountRepository.findById(IDDiscount)
                .orElseThrow(() -> new DiscountNotFound((IDDiscount)));
        List<Discount> temp = new ArrayList<>(Arrays.asList(discount));
        product.setDiscounts(temp);
        productRepository.save(product);
        return "Successfully updated!";
    }

    @DeleteMapping
    public String deleteProduct(@RequestParam Long id) {
        productRepository.deleteById(id);
        return "Successfully deleted!";
    }

}
