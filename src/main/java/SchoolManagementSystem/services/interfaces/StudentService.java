package SchoolManagementSystem.services.interfaces;


import java.util.List;

public interface StudentService {

    String addStudent(List<String> studentData);


    String viewStudentInfo(String[] viewStudentData);

    String addMark(String[] studentMarkData);

    String addClub(String[] studentClubData);

    String addParent(List<String> studentParentData);
}
