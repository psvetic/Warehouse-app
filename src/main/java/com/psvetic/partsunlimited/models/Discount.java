package com.psvetic.partsunlimited.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "discounts", schema = "partsunlimited")
public class Discount {

    @Id
    private Long IDDiscount;

    private LocalDate startingDate;
    private LocalDate endingDate;
    private float percent;

    @ManyToMany(mappedBy = "discounts")
    @JsonIgnore
    private List<Product> products;

    public Discount() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getIDDiscount() {
        return IDDiscount;
    }

    public void setIDDiscount(Long IDDiscount) {
        this.IDDiscount = IDDiscount;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
