package SchoolManagementSystem;

import SchoolManagementSystem.services.interfaces.*;
import SchoolManagementSystem.services.seed.BaseSeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static SchoolManagementSystem.constants.Commands.*;
import static SchoolManagementSystem.constants.ConsoleMessages.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);

    private final BaseSeedService baseSeedService;

    private final StudentService studentService;

    private final TeacherService teacherService;

    private final EmployeeService employeeService;

    private final ClubService clubService;

    private final TownService townService;

    private final CountryService countryService;

    @Autowired
    public ConsoleRunner(BaseSeedService baseSeedService, StudentService studentService, TeacherService teacherService, EmployeeService employeeService, ClubService clubService, TownService townService, CountryService countryService) {
        this.baseSeedService = baseSeedService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.employeeService = employeeService;
        this.clubService = clubService;
        this.townService = townService;
        this.countryService = countryService;
    }


    @Override
    public void run(String... args) throws Exception {
        baseSeedService.seedAllBaseData();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {

            String result = switch (input) {
                case ADD_STUDENT_COMMAND -> studentService.addStudent(requestAddStudentInformation());
                case ADD_TEACHER_COMMAND -> teacherService.addTeacher(requestAddTeacherInformation());
                case VIEW_STUDENT_INFO -> studentService.viewStudentInfo(requestViewInformation());
                case VIEW_TEACHER_INFO -> teacherService.viewTeacherInfo(requestViewInformation());

                default -> "No such command!";
            };

            System.out.println(result);
            input = scanner.nextLine();
        }
    }

    private String[] requestViewInformation() {
        System.out.print(PERSON_FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.print(PERSON_LAST_NAME);
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
