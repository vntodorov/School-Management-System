package SchoolManagementSystem.models.DTOs;

import SchoolManagementSystem.models.DTOs.base.AddPersonEntityDTO;
import SchoolManagementSystem.models.entities.Town;
import SchoolManagementSystem.models.enums.Gender;

import java.time.LocalDate;

public class AddStudentDTO extends AddPersonEntityDTO {

    private LocalDate enrollDate;

    public AddStudentDTO(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        this.enrollDate = LocalDate.now();
    }

    public LocalDate getEnrollDate(){
        return this.enrollDate;
    }

}
