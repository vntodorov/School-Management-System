package com.iStudent.model.DTOs;

import com.iStudent.model.DTOs.base.PersonEntityDTO;
import com.iStudent.model.validation.PhoneNumber;

import javax.validation.constraints.NotBlank;

public class ParentDTO extends PersonEntityDTO {

    @NotBlank
    @PhoneNumber
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
