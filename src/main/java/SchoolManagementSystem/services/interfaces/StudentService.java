package SchoolManagementSystem.services.interfaces;


import java.util.List;

public interface StudentService {

    String addStudent(List<String> studentData);


    String viewStudentInfo(String[] viewStudentData);
}
