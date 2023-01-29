package SchoolManagementSystem.models.entities;

import SchoolManagementSystem.models.entities.base.BasePersonEntity;
import SchoolManagementSystem.models.enums.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BasePersonEntity {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;



    private Teacher(){}

    public Teacher(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email, Subject subject) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());
        out.append(System.lineSeparator())
                .append("Subject: ").append(subject.getName()).append(System.lineSeparator());

        return out.toString().trim();

    }
}
