package SchoolManagementSystem.services.interfaces;

import java.util.List;

public interface EmployeeService {
    String addEmployee(List<String> employeeData);

    String viewEmployeeInfo(String[] viewEmployeeData);
}
