package SchoolManagementSystem.models.entities;

import SchoolManagementSystem.models.entities.base.BasePersonEntity;
import SchoolManagementSystem.models.enums.Gender;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parents")
public class Parent extends BasePersonEntity {

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    Set<Student> students;

    private Parent(){}

    public Parent(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email, String phoneNumber) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        setPhoneNumber(phoneNumber);
        this.students = new HashSet<>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }
}
