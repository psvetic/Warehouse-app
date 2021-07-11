package com.psvetic.partsunlimited.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "models")
@Table(name = "models", schema = "partsunlimited")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Model {

    @Id
    private Long IDModel;

    private Long IDMake;
    private String name;

    @ManyToOne
    @JoinColumn(name = "idmake", insertable = false, updatable = false)
    private Make makes;

    @ManyToMany(mappedBy = "models")
    @JsonIgnore
    private List<Part> parts;

    public Model() {
    }

    public Make getMakes() {
        return makes;
    }

    public void setMakes(Make makes) {
        this.makes = makes;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Long getIDModel() {
        return IDModel;
    }

    public void setIDModel(Long IDModel) {
        this.IDModel = IDModel;
    }

    public Long getIDMake() {
        return IDMake;
    }

    public void setIDMake(Long IDMake) {
        this.IDMake = IDMake;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
