package SchoolManagementSystem.models.DTOs;

import SchoolManagementSystem.models.DTOs.base.AddPersonEntityDTO;
import SchoolManagementSystem.models.entities.Town;
import SchoolManagementSystem.models.enums.Gender;

public class AddTeacherDTO extends AddPersonEntityDTO {

    private SubjectDTO subject;


    public AddTeacherDTO(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email, SubjectDTO subject) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        setSubject(subject);
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }
}
