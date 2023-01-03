package SchoolManagementSystem;

import SchoolManagementSystem.services.interfaces.*;
import SchoolManagementSystem.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static SchoolManagementSystem.Constants.Commands.*;
import static SchoolManagementSystem.Constants.ConsoleMessages.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);

    private final SeedService seedService;

    private final StudentService studentService;

    private final TeacherService teacherService;

    private final EmployeeService employeeService;

    private final ClubService clubService;

    private final TownService townService;

    @Autowired
    public ConsoleRunner(SeedService seedService, StudentService studentService, TeacherService teacherService, EmployeeService employeeService, ClubService clubService, TownService townService) {
        this.seedService = seedService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.employeeService = employeeService;
        this.clubService = clubService;
        this.townService = townService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedNeededData();

        String input = scanner.nextLine();

        while (!"End".equals(input)){

            switch (input){
                case ADD_STUDENT_COMMAND:
                    System.out.println(studentService.addStudent(requestStudentInformation()));
                    break;
                case ADD_TEACHER_COMMAND:
                    System.out.println(teacherService.addTeacher(requestTeacherInformation()));
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private List<String> requestStudentInformation() {
        System.out.println(ADD_STUDENT_BEGIN);
        return requestPersonInformation();
    }

    private List<String> requestTeacherInformation(){
        System.out.println(ADD_TEACHER_BEGIN);
        List<String> teacherData = new ArrayList<>(requestPersonInformation());

        System.out.print(TEACHER_SUBJECT);
        String subject = scanner.nextLine();
        teacherData.add(subject);

        return teacherData;


    }

    private List<String> requestPersonInformation(){

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

    private void seedNeededData() throws IOException {
        seedService.seedNeededData();
    }
}
