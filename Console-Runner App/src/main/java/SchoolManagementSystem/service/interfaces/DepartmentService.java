package SchoolManagementSystem.service.interfaces;

import SchoolManagementSystem.models.entities.Department;

import java.util.List;

public interface DepartmentService {

    boolean isDataSeeded();

    void seedDepartments(List<Department> departments);

    Department findByName (String departmentName);

}
