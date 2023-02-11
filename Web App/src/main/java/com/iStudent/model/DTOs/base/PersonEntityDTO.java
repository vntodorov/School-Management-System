package com.iStudent.model.DTOs.base;


import com.iStudent.model.DTOs.TownDTO;
import com.iStudent.model.entity.enums.Gender;
import com.iStudent.model.validation.UniqueEmail;
import com.iStudent.model.validation.ValidEGN;
import com.iStudent.model.validation.ValidGender;
import com.iStudent.model.validation.ValidTown;
import javax.validation.constraints.*;

public abstract class PersonEntityDTO {

    @NotNull
    private Long id;

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
    private TownDTO town;

    @NotEmpty
    @Email
    @UniqueEmail
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public TownDTO getTown() {
        return town;
    }

    public void setTown(TownDTO town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
