package com.iStudent.model.DTOs;

import com.iStudent.model.DTOs.base.PersonEntityDTO;

import java.time.LocalDate;

public class StudentDTO extends PersonEntityDTO {

    private final LocalDate enrollDate = LocalDate.now();

    public LocalDate getEnrollDate() {
        return enrollDate;
    }
}
