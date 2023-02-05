package SchoolManagementSystem.model.entity;

import SchoolManagementSystem.model.entity.base.BasePersonEntity;
import SchoolManagementSystem.model.entity.enums.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BasePersonEntity {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

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