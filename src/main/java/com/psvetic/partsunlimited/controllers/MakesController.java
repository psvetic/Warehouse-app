package com.psvetic.partsunlimited.controllers;

import com.psvetic.partsunlimited.models.Make;
import com.psvetic.partsunlimited.repositories.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/makes")
public class MakesController {
    @Autowired
    private MakeRepository makeRepository;

    @GetMapping
    public List<Make> list() {
        return makeRepository.findAll();
    }

    @PostMapping
    public Make create(@RequestBody Make make) {
        return makeRepository.saveAndFlush(make);
    }
}
