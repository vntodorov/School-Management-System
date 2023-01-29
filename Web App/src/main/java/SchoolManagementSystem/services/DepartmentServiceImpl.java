package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.entities.Department;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.DepartmentRepository;
import SchoolManagementSystem.services.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static SchoolManagementSystem.constants.EntityExceptionMessages.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.departmentRepository.count() > 0;
    }

    @Override
    public void seedDepartments(List<Department> departments) {
        this.departmentRepository.saveAll(departments);
    }

    @Override
    public Department findByName(String departmentName) {
        return this.departmentRepository.findByName(departmentName).orElseThrow(() -> new EntityException(String.format(DEPARTMENT_EXCEPTION, departmentName)));
    }
}
