package com.psvetic.partsunlimited.controllers;

import com.psvetic.partsunlimited.models.Model;
import com.psvetic.partsunlimited.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelsController {
    @Autowired
    private ModelRepository modelRepository;

    @GetMapping
    public List<Model> list() {
        return modelRepository.findAll();
    }

    @PostMapping
    public Model create(@RequestBody Model model) {
        return modelRepository.saveAndFlush(model);
    }
}
