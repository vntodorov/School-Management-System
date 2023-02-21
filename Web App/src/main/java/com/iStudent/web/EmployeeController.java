package com.iStudent.web;

import com.iStudent.model.DTOs.EmployeeDTO;
import com.iStudent.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return ResponseEntity.
                ok(employeeService.getAllEmployees());

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){

        Optional<EmployeeDTO> employee = employeeService.getEmployeeById(employeeId);

        if (employee.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();

        } else {
            return ResponseEntity
                    .ok(employee.get());

        }
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,
                                                 UriComponentsBuilder uriComponentsBuilder) {

        long newEmployeeId = employeeService.addEmployee(employeeDTO);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/employees/{id}")
                        .build(newEmployeeId))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        this.employeeService.deleteEmployeeById(employeeId);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<EmployeeDTO> changeDepartment(@Valid @RequestBody EmployeeDTO employeeDTO,
                                                    @PathVariable("id") Long id) {

        EmployeeDTO employee = this.employeeService.changeEmployeeDetails(id, employeeDTO);

        if (employee == null) {
            return ResponseEntity
                    .notFound()
                    .build();

        } else {
            return ResponseEntity
                    .ok(employee);
        }
    }
}
