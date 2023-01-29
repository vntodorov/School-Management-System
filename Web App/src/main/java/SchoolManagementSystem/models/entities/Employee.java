package SchoolManagementSystem.models.entities;

import SchoolManagementSystem.models.entities.base.BasePersonEntity;
import SchoolManagementSystem.models.enums.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends BasePersonEntity {

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "work_hours", nullable = false)
    private int workHours;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private Employee() {
    }

    public Employee(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email, String jobTitle, int workHours, Department department) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        this.jobTitle = jobTitle;
        this.workHours = workHours;
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());

        out.append(System.lineSeparator())
                .append("Job title: ").append(jobTitle).append(System.lineSeparator())
                .append("Work hours: ").append(workHours).append(System.lineSeparator())
                .append("Department: ").append(department.getName());

        return out.toString().trim();
    }
}
