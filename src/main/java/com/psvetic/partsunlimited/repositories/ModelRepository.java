package com.psvetic.partsunlimited.repositories;

import com.psvetic.partsunlimited.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByMakes_name(String name);
}
