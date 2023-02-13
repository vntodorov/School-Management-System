package com.iStudent.service;

import com.iStudent.model.DTOs.UserDTO;
import com.iStudent.model.DTOs.UserRegisterDTO;
import com.iStudent.model.entity.users.Role;
import com.iStudent.model.entity.users.UserEntity;
import com.iStudent.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.iStudent.model.entity.users.RolesEnum.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final EmployeeRepository employeeRepository;

    private final ParentRepository parentRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, EmployeeRepository employeeRepository, ParentRepository parentRepository, RoleRepository roleRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.employeeRepository = employeeRepository;
        this.parentRepository = parentRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }


    public UserDTO registerUser(UserRegisterDTO userRegisterDTO) {

        UserEntity user = mapper.map(userRegisterDTO, UserEntity.class);

        //TODO: encode the password!

        String currentUserEmail = user.getEmail();

        user.setRole(identifyRole(currentUserEmail));

        userRepository.save(user);

        return map(user);

    }

    private Role identifyRole(String currentUserEmail) {

        if (studentRepository.findByEmail(currentUserEmail).isPresent()) {
            return roleRepository.findByRole(STUDENT.name()).orElseThrow();

        } else if (teacherRepository.findByEmail(currentUserEmail).isPresent()) {
            return roleRepository.findByRole(TEACHER.name()).orElseThrow();

        } else if (employeeRepository.findByEmail(currentUserEmail).isPresent()) {
            return roleRepository.findByRole(EMPLOYEE.name()).orElseThrow();

        } else {
            return roleRepository.findByRole(PARENT.name()).orElseThrow();

        }
    }

    private UserDTO map(UserEntity userEntity) {
        return new UserDTO().
                setEmail(userEntity.getEmail()).
                setRole(userEntity.getRole().getRole().name());
    }
}
