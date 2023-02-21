package com.iStudent.service;

import com.iStudent.model.DTOs.EmployeeDTO;
import com.iStudent.model.entity.Department;
import com.iStudent.model.entity.Employee;
import com.iStudent.model.entity.Town;
import com.iStudent.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final TownService townService;

    private final DepartmentService departmentService;

    private final ModelMapper mapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, TownService townService, DepartmentService departmentService, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.townService = townService;
        this.departmentService = departmentService;
        this.mapper = mapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.
                findAll().
                stream().
                map(this::mapToEmployeeDTO).
                toList();
    }

    private EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return mapper.map(employee, EmployeeDTO.class);
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.
                findById(id).
                map(this::mapToEmployeeDTO);
    }

    public long addEmployee(EmployeeDTO employeeDTO) {

        Town townToMap = townService.findByTownId(employeeDTO.getTown().getId());
        Department departmentToMap = departmentService.findDepartmentById(employeeDTO.getDepartment().getId());

        Employee employee = mapper.map(employeeDTO, Employee.class);
        employee.setTown(townToMap);
        employee.setDepartment(departmentToMap);

        employeeRepository.save(employee);

        return employee.getId();
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public EmployeeDTO changeEmployeeDetails(Long employeeId, EmployeeDTO employeeDTO) {
        Department newDepartment = departmentService.findDepartmentById(employeeDTO.getDepartment().getId());
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setJobTitle(employeeDTO.getJobTitle());
            employee.setWorkHours(employeeDTO.getWorkHours());
            employee.setDepartment(newDepartment);
            employeeRepository.save(employee);
            return mapToEmployeeDTO(employee);
        }

        return null;

    }
}
