package SchoolManagementSystem.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department extends BaseEntityWithIdLong{

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    private Department(){}

    public Department(String name){
        setName(name);
        this.employees = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }



}
