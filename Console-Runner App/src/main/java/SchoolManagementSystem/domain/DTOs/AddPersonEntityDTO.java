package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;

import java.util.regex.Pattern;

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
            throw new EntityException("EGN must be a 10-digit number");
        }
        this.EGN = EGN;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new EntityException("Age must be a valid number!");
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
        String emailValidator = "^[^\\?=.@,\\/\\\\;'\\[\\]-][A-Za-z\\d_-]+(\\.[A-Za-z\\d_-]+)*@[A-Za-z]+(\\.[A-Za-z\\d-]+)*(\\.[A-Za-z]{2,})$";
        if (!Pattern.compile(emailValidator).matcher(email).matches()) {
            throw new EntityException("Invalid email!");
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
