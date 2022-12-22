package SchoolManagementSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends BasePersonEntity{

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "work_hours")
    private int workHours;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private Employee(){}

    public Employee(String firstName, String middleName, String lastName, int EGN, int age, String jobTitle, int workHours, Department department){
        super(firstName, middleName, lastName, EGN, age);
        this.jobTitle = jobTitle;
        this.workHours = workHours;
        this.department = department;
    }

}
