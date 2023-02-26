package com.iStudent.model.DTOs;

import com.iStudent.model.validation.UniqueClubName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClubDTO {

    @NotBlank
    @Size(min = 2, max = 20)
    @UniqueClubName
    private String name;

    @NotBlank
    @Size(min = 5, max = 500)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
