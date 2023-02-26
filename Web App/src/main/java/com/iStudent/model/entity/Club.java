package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BaseEntityWithIdLong;


import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clubs")
public class Club extends BaseEntityWithIdLong {

    @Column(unique = true)
    private String name;

    @Column(length = 500, columnDefinition = "text")
    private String description;

    @ManyToMany(mappedBy = "clubs", fetch = FetchType.LAZY)
    private Set<Student> students;

    public Club() {
        this.students = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addStudentToClub(Student student) {
        students.add(student);
    }

    public void removeStudentFromClub(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    @Override
    public String toString() {
        return "Club's name: " + name + System.lineSeparator()
                + "Club's description: " + description;
    }
}
