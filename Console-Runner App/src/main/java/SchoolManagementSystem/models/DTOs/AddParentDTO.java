package SchoolManagementSystem.models.DTOs;

import SchoolManagementSystem.models.DTOs.base.AddPersonEntityDTO;
import SchoolManagementSystem.models.entities.Town;
import SchoolManagementSystem.models.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;

import static SchoolManagementSystem.util.EntityExceptionMessages.PHONE_EXCEPTION;

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
