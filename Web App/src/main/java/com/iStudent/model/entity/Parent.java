package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BasePersonEntity;
import javax.persistence.*;


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
