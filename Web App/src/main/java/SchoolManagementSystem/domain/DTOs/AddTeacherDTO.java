package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.DTOs.base.AddPersonEntityDTO;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;

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
