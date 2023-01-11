package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.DTOs.base.AddPersonEntityDTO;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;

import static SchoolManagementSystem.constants.EntityExceptionMessages.*;

public class AddEmployeeDTO extends AddPersonEntityDTO {

    private String jobTitle;

    private int workHours;

    private DepartmentDTO department;

    public AddEmployeeDTO(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email, String jobTitle, int workHours, DepartmentDTO department) {
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
        if (workHours <= 0) {
            throw new EntityException(WORK_HOURS_EXCEPTION);
        }
        this.workHours = workHours;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }
}
