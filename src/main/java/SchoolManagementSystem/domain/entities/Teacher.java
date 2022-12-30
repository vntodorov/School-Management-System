package SchoolManagementSystem.domain.entities;

import SchoolManagementSystem.domain.enums.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BasePersonEntity{

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;



    private Teacher(){}

    public Teacher(String firstName, String middleName, String lastName, int EGN, int age, Gender gender, Town town, String email, Subject subject) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }
}
