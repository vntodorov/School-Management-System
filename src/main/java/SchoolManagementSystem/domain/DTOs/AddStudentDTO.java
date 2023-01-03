package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.entities.Club;
import SchoolManagementSystem.domain.entities.Parent;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.domain.enums.Mark;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
