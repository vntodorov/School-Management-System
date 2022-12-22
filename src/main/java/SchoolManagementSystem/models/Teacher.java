package SchoolManagementSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BasePersonEntity{

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    private Teacher(){}

    public Teacher(String firstName, String middleName, String lastName, int EGN,  int age, String email, Subject subject) {
        super(firstName, middleName, lastName, EGN, age);
        this.email = email;
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public Subject getSubject() {
        return subject;
    }
}
