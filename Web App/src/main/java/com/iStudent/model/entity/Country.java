package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BaseEntityWithIdLong;
import javax.persistence.*;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntityWithIdLong {

    @Column
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Town> towns;

    public Country(){
        this.towns = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Town> getTowns() {
        return Collections.unmodifiableSet(towns);
    }

}
