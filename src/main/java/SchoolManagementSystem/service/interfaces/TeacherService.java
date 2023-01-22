package SchoolManagementSystem.service.interfaces;

import java.util.List;

public interface TeacherService {

    String addTeacher(List<String> teacherData);

    String viewTeacherInfo(String[] viewTeacherData);
}
