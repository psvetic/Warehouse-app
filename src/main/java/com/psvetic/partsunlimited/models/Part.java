package com.psvetic.partsunlimited.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "parts", schema = "partsunlimited")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Part {

    @Id
    private Long serialNumber;

    private LocalDate manufactureDate;
    private String partName;

    @ManyToMany
    @JoinTable(
            name = "model_parts",
            schema = "partsunlimited",
            joinColumns = @JoinColumn(name = "serial_number"),
            inverseJoinColumns = @JoinColumn(name = "idmodel")
    )
    private List<Model> models;

    public Part() {
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
}
