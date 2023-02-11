package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BaseEntityWithIdLong;
import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department extends BaseEntityWithIdLong {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    public Department(){
        this.employees = new HashSet<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
