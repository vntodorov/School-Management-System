package SchoolManagementSystem.runner;

import SchoolManagementSystem.service.interfaces.*;
import SchoolManagementSystem.service.seed.BaseSeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static SchoolManagementSystem.util.Commands.*;
import static SchoolManagementSystem.util.ConsoleMessages.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);

    private final BaseSeedService baseSeedService;

    private final StudentService studentService;

    private final TeacherService teacherService;

    private final EmployeeService employeeService;

    private final ClubService clubService;

    @Autowired
    public ConsoleRunner(BaseSeedService baseSeedService, StudentService studentService, TeacherService teacherService, EmployeeService employeeService, ClubService clubService) {
        this.baseSeedService = baseSeedService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.employeeService = employeeService;
        this.clubService = clubService;
    }


    @Override
    public void run(String... args) throws Exception {
        baseSeedService.seedAllBaseData();

        System.out.println(INSTRUCTION_START_MESSAGE);
        System.out.print(TYPE_NUMBER);

        int input = Integer.parseInt(scanner.nextLine());

        while (0 != input) {

            String result = switch (input) {

                case 1 -> studentService.addStudent(requestAddStudentInformation());
                case 2 -> teacherService.addTeacher(requestAddTeacherInformation());
                case 3 -> employeeService.addEmployee(requestAddEmployeeInformation());
                case 4 -> clubService.addClub(requestClubInformation());
                case 5 -> studentService.addMark(requestAddMarkToStudentInformation());
                case 6 -> studentService.addClub(requestAddClubToStudentInformation());
                case 7 -> studentService.addParent(requestAddParentToStudentInformation());
                case 8 -> studentService.viewStudentInfo(requestViewPersonInformation());
                case 9 -> teacherService.viewTeacherInfo(requestViewPersonInformation());
                case 10 -> employeeService.viewEmployeeInfo(requestViewPersonInformation());
                case 11 -> clubService.viewClubInformation(requestViewClubInformation());

                default -> "No such command!";
            };

            System.out.println(result);
            System.out.print(TYPE_NUMBER);
            input = Integer.parseInt(scanner.nextLine());
        }
    }

    private List<String> requestAddParentToStudentInformation() {
        System.out.println(ADD_PARENT_TO_STUDENT_BEGIN);
        List<String> studentParent = new ArrayList<>(requestPersonInformation());

        System.out.print(PARENT_PHONE_NUMBER);
        String phoneNumber = scanner.nextLine();
        studentParent.add(phoneNumber);

        System.out.println(REQUEST_STUDENT_INFO_AFTER);

        System.out.print(STUDENT_FIRST_NAME);
        String studentFirstName = scanner.nextLine();

        System.out.print(STUDENT_LAST_NAME);
        String studentLastName = scanner.nextLine();

        studentParent.add(studentFirstName);
        studentParent.add(studentLastName);

        return studentParent;
    }

    private String[] requestAddMarkToStudentInformation() {
        System.out.println(ADD_MARK_TO_STUDENT_BEGIN);

        System.out.print(STUDENT_FIRST_NAME);
        String studentFirstName = scanner.nextLine();

        System.out.print(STUDENT_LAST_NAME);
        String studentLastName = scanner.nextLine();

        System.out.print(MARK);
        String mark = scanner.nextLine();

        return new String[]{studentFirstName, studentLastName, mark};

    }

    private String[] requestAddClubToStudentInformation() {
        System.out.println(ADD_CLUB_TO_STUDENT_BEGIN);

        System.out.print(STUDENT_FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.print(STUDENT_LAST_NAME);
        String lastName = scanner.nextLine();

        System.out.print(CLUB_NAME);
        String clubName = scanner.nextLine();

        return new String[]{firstName, lastName, clubName};
    }

    private String requestViewClubInformation() {
        System.out.print(CLUB_NAME);
        return scanner.nextLine();
    }

    private String[] requestClubInformation() {
        System.out.println(ADD_CLUB_BEGIN);

        System.out.print(CLUB_NAME);
        String clubName = scanner.nextLine();

        System.out.print(CLUB_DESCRIPTION);
        String clubDescription = scanner.nextLine();
        return new String[]{clubName, clubDescription};
    }

    private String[] requestViewPersonInformation() {
        System.out.print(STUDENT_FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.print(STUDENT_LAST_NAME);
        String lastName = scanner.nextLine();

        return new String[]{firstName, lastName};
    }

    private List<String> requestAddStudentInformation() {
        System.out.println(ADD_STUDENT_BEGIN);
        return requestPersonInformation();
    }

    private List<String> requestAddTeacherInformation() {
        System.out.println(ADD_TEACHER_BEGIN);
        List<String> teacherData = new ArrayList<>(requestPersonInformation());

        System.out.print(TEACHER_SUBJECT);
        String subject = scanner.nextLine();
        teacherData.add(subject);

        return teacherData;
    }

    private List<String> requestAddEmployeeInformation() {
        System.out.println(ADD_EMPLOYEE_BEGIN);
        List<String> employeeData = new ArrayList<>(requestPersonInformation());

        System.out.print(EMPLOYEE_JOB_TITLE);
        String jobTitle = scanner.nextLine();

        System.out.print(EMPLOYEE_WORK_HOURS);
        String workHours = scanner.nextLine();

        System.out.print(EMPLOYEE_DEPARTMENT);
        String department = scanner.nextLine();


        employeeData.add(jobTitle);
        employeeData.add(workHours);
        employeeData.add(department);

        return employeeData;
    }


    private List<String> requestPersonInformation() {

        System.out.print(PERSON_FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.print(PERSON_MIDDLE_NAME);
        String middleName = scanner.nextLine();

        System.out.print(PERSON_LAST_NAME);
        String lastName = scanner.nextLine();

        System.out.print(PERSON_EGN);
        String EGN = scanner.nextLine();

        System.out.print(PERSON_AGE);
        String age = scanner.nextLine();

        System.out.print(PERSON_GENDER);
        String gender = scanner.nextLine();

        System.out.print(PERSON_TOWN);
        String townName = scanner.nextLine();

        System.out.print(PERSON_EMAIL);
        String email = scanner.nextLine();

        return List.of(firstName, middleName, lastName, EGN, age, gender, townName, email);
    }

}
