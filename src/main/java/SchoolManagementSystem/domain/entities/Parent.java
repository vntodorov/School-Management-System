package SchoolManagementSystem.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parents")
public class Parent extends BasePersonEntity{

    @Column
    private int phoneNumber;

    @OneToMany(mappedBy = "parent")
    Set<Student> students;

    private Parent(){}

    public Parent(String firstName, String middleName, String lastName, int EGN, int age, Town town, String email, int phoneNumber) {
        super(firstName, middleName, lastName, EGN, age, town, email);
        setPhoneNumber(phoneNumber);
        this.students = new HashSet<>();
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }
}
