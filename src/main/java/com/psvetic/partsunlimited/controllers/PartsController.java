package com.psvetic.partsunlimited.controllers;

import com.psvetic.partsunlimited.exceptions.ModelNotFound;
import com.psvetic.partsunlimited.exceptions.PartNotFound;
import com.psvetic.partsunlimited.models.*;
import com.psvetic.partsunlimited.repositories.ModelRepository;
import com.psvetic.partsunlimited.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping
    public List<Part> getPartsById(@RequestParam(required = false) Long id) {
        if (id == null) {
            return partRepository.findAll();
        }
        else {
            return Arrays.asList(partRepository.getOne(id));
        }
    }

    @GetMapping
    @RequestMapping("/manufactureDate")
    // NOTE: localhost:8080/parts/manufactureDate?date=2020-01-20
    public List<Part> getPartsByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
        return partRepository.findByManufactureDate(date);
    }

    @GetMapping
    @RequestMapping("/customName")
    // NOTE: localhost:8080/parts/customName?name=Dodge%20Viper (or name=Audi)
    public List<MakeAndModel> getPartsByMakeAndModel(@RequestParam String name) {
        return partRepository.searchMakeAndModel(name);
    }

    @GetMapping
    @RequestMapping("/count")
    // NOTE: localhost:8080/parts/count?name=Dodge%20Viper (or name=Audi)
    public List<MakeAndModelCount> getCount(@RequestParam String name) {
        return partRepository.makeAndModelCount(name);
    }

    @PostMapping
    public Part createPart(@RequestBody Part part) {
        return partRepository.saveAndFlush(part);
    }

    @PutMapping
    public String updateModels(@RequestParam Long id, @RequestBody Long IDModel) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new PartNotFound(id));
        Model model = modelRepository.findById(IDModel)
                .orElseThrow(() -> new ModelNotFound((IDModel)));
        List<Model> temp = new ArrayList<>(Arrays.asList(model));
        part.setModels(temp);
        partRepository.save(part);
        return "Successfully updated!";
    }

    @DeleteMapping
    public String deletePart(@RequestParam Long id) {
        partRepository.deleteById(id);
        return "Successfully deleted!";
    }
}
