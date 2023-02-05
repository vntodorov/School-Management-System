package SchoolManagementSystem.model.entity;

import SchoolManagementSystem.model.entity.base.BasePersonEntity;
import SchoolManagementSystem.model.entity.enums.Gender;
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

    public Parent(){
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
