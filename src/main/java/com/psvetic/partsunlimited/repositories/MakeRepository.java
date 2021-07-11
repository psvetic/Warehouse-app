package com.psvetic.partsunlimited.repositories;

import com.psvetic.partsunlimited.models.Make;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeRepository extends JpaRepository<Make, Long> {
    // List<Make> findBy(String name);
}
