package SchoolManagementSystem.services.interfaces;


import SchoolManagementSystem.domain.DTOs.CreateStudentDTO;
import SchoolManagementSystem.domain.entities.Student;

public interface StudentService {

    void addStudent(CreateStudentDTO student);


}
