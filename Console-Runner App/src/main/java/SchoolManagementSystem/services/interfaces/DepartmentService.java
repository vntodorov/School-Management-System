package SchoolManagementSystem.services.interfaces;

import SchoolManagementSystem.domain.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    boolean isDataSeeded();

    void seedDepartments(List<Department> departments);

    Department findByName (String departmentName);

}
