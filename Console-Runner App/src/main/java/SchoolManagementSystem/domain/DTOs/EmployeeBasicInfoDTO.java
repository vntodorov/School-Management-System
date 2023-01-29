package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.DTOs.base.ViewPersonInfoDTO;

import static SchoolManagementSystem.constants.Validations.SUCCESSFULLY_VIEW_EMPLOYEE;

public class EmployeeBasicInfoDTO extends ViewPersonInfoDTO {

    private String jobTitle;

    private int workHours;

    private DepartmentDTO department;

    public EmployeeBasicInfoDTO() {
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

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format(SUCCESSFULLY_VIEW_EMPLOYEE, super.toString() + System.lineSeparator()
                + "    Job title: " + jobTitle + System.lineSeparator()
                + "    Work hours: " + workHours + System.lineSeparator()
                + "    Department: " + department.getName());
    }
}
