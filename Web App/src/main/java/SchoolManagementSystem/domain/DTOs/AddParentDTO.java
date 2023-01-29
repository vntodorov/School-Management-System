package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.DTOs.base.AddPersonEntityDTO;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;

import static SchoolManagementSystem.constants.EntityExceptionMessages.PHONE_EXCEPTION;

public class AddParentDTO extends AddPersonEntityDTO {

    private String phoneNumber;


    public AddParentDTO(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email, String phoneNumber) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        setPhoneNumber(phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10){
            throw new EntityException(PHONE_EXCEPTION);
        }
        this.phoneNumber = phoneNumber;
    }
}
