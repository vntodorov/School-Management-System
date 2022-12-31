package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.entities.Club;
import SchoolManagementSystem.domain.entities.Parent;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.domain.enums.Mark;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateStudentDTO extends CreatePersonDTO{

    private Parent parent;

    private Set<Club> clubs;

    private List<Mark> marks;

    private LocalDate enrollDate;


    public CreateStudentDTO(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        this.clubs = new HashSet<>();
        this.marks = new ArrayList<>();
        this.enrollDate = LocalDate.now();
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }
}
