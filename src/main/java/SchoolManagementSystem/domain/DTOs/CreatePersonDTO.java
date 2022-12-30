package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;

public abstract class CreatePersonDTO {

    private String firstName;

    private String middleName;

    private String lastName;

    private int EGN;

    private int age;

    private Gender gender;

    private Town town;

    private String email;

    public CreatePersonDTO(String firstName, String middleName, String lastName, int EGN, int age, Gender gender, Town town, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.EGN = EGN;
        this.age = age;
        this.gender = gender;
        this.town = town;
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

    public int getEGN() {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEGN(int EGN) {
        this.EGN = EGN;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
