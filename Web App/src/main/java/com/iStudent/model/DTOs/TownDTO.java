package com.iStudent.model.DTOs;

import javax.validation.constraints.NotBlank;

public class TownDTO {

    private Long id;

    @NotBlank
    private String name;

    private CountryDTO country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
