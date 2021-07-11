package com.psvetic.partsunlimited.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "makes", schema = "partsunlimited")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Make {

    @Id
    private Long IDMake;
    private String name;

    @OneToMany(mappedBy = "makes")
    @JsonIgnore
    private List<Model> models;

    public Make() {
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
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
