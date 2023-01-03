package SchoolManagementSystem.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntityWithIdLong{

    @Column
    private String name;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.PERSIST)
    private Teacher teacher;

    public Subject(){}

    public Subject(String name, Teacher teacher){
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
