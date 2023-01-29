package SchoolManagementSystem.domain.DTOs.base;

import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;

import java.util.regex.Pattern;

import static SchoolManagementSystem.constants.EntityExceptionMessages.*;
import static SchoolManagementSystem.constants.Validations.EMAIL_VALIDATOR;

public abstract class AddPersonEntityDTO {

    private String firstName;

    private String middleName;

    private String lastName;

    private String EGN;

    private int age;

    private Gender gender;

    private Town town;

    private String email;

    public AddPersonEntityDTO(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setEGN(EGN);
        setAge(age);
        setGender(gender);
        setTown(town);
        setEmail(email);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEGN(String EGN) {
        if (EGN.length() != 10) {
            throw new EntityException(EGN_EXCEPTION);
        }
        this.EGN = EGN;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new EntityException(AGE_EXCEPTION);
        }
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setEmail(String email) {
        if (!Pattern.compile(EMAIL_VALIDATOR).matcher(email).matches()) {
            throw new EntityException(EMAIL_EXCEPTION);
        }
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEGN() {

        return EGN;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Town getTown() {
        return town;
    }

    public String getEmail() {
        return email;
    }
}
