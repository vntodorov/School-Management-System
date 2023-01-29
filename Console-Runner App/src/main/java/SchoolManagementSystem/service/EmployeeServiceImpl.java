package SchoolManagementSystem.service;

import SchoolManagementSystem.models.DTOs.AddEmployeeDTO;
import SchoolManagementSystem.models.DTOs.DepartmentDTO;
import SchoolManagementSystem.models.DTOs.EmployeeBasicInfoDTO;
import SchoolManagementSystem.models.entities.Department;
import SchoolManagementSystem.models.entities.Employee;
import SchoolManagementSystem.models.entities.Town;
import SchoolManagementSystem.models.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repository.EmployeeRepository;
import SchoolManagementSystem.service.interfaces.DepartmentService;
import SchoolManagementSystem.service.interfaces.EmployeeService;
import SchoolManagementSystem.service.interfaces.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static SchoolManagementSystem.util.Validations.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final TownService townService;

    private final DepartmentService departmentService;

    private final ModelMapper modelMapper;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, TownService townService, DepartmentService departmentService, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.townService = townService;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addEmployee(List<String> employeeData) {

        String firstName = employeeData.get(0);
        String middleName = employeeData.get(1);
        String lastName = employeeData.get(2);
        String EGN = employeeData.get(3);
        int age = Integer.parseInt(employeeData.get(4));
        Gender gender = Gender.valueOf(employeeData.get(5));
        String townName = employeeData.get(6);
        String email = employeeData.get(7);

        String jobTitle = employeeData.get(8);
        int workHours = Integer.parseInt(employeeData.get(9));
        String department = employeeData.get(10);

        DepartmentDTO departmentDTO = new DepartmentDTO(department);

        AddEmployeeDTO employeeDTO;

        String resultOfAddingTown = townService.addTown(townName);

        if (resultOfAddingTown.equals(NO_ANSWER)) {
            return NO_ANSWER;
        } else if (resultOfAddingTown.equals(SUCCESSFULLY_ADDED_TOWN)) {
            System.out.println(resultOfAddingTown);
        }

        Town town = townService.findByName(townName);

        try {
            employeeDTO = new AddEmployeeDTO(firstName, middleName, lastName, EGN, age, gender, town, email, jobTitle, workHours, departmentDTO);
        } catch (EntityException e) {
            return e.getMessage();
        }

        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        Department departmentToAdd = departmentService.findByName(employee.getDepartment().getName());
        employee.setDepartment(departmentToAdd);

        employeeRepository.save(employee);

        return String.format(SUCCESSFULLY_ADDED_EMPLOYEE, employee);
    }

    @Override
    public String viewEmployeeInfo(String[] viewEmployeeData) {
        String firstName = viewEmployeeData[0];
        String lastName = viewEmployeeData[1];

        Optional<Employee> employee = this.employeeRepository.findByFirstNameAndLastName(firstName, lastName);

        if (employee.isEmpty()) {
            return String.format(EMPLOYEE_DOES_NOT_EXIST, firstName, lastName);
        }

        EmployeeBasicInfoDTO employeeToShow = this.modelMapper.map(employee, EmployeeBasicInfoDTO.class);

        return employeeToShow.toString();
    }
}
