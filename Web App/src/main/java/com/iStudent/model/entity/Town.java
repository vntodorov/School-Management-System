package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BaseEntityWithIdLong;
import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntityWithIdLong {

    @Column
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
