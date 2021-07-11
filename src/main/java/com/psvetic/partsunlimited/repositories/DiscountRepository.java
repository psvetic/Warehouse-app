package com.psvetic.partsunlimited.repositories;

import com.psvetic.partsunlimited.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
