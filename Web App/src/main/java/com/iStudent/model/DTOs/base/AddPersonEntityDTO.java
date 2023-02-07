package com.iStudent.model.DTOs.base;


import com.iStudent.model.entity.Town;
import com.iStudent.model.entity.enums.Gender;
import com.iStudent.model.validation.UniqueEmail;
import com.iStudent.model.validation.ValidEGN;
import com.iStudent.model.validation.ValidGender;
import com.iStudent.model.validation.ValidTown;
import jakarta.validation.constraints.*;

public abstract class AddPersonEntityDTO {

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String middleName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty
    @ValidEGN
    private String EGN;

    @Positive
    @Min(14)
    private int age;

    @ValidGender(anyOf = {Gender.M, Gender.F})
    private Gender gender;

    @NotNull
    @ValidTown
    private Town town;

    @NotEmpty
    @Email
    @UniqueEmail
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
