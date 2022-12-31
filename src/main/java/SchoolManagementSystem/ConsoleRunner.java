package SchoolManagementSystem;

import SchoolManagementSystem.domain.DTOs.CreateStudentDTO;
import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.services.interfaces.*;
import SchoolManagementSystem.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

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

        //addStudent();

    }

    private void addStudent() {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String middleName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String EGN = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Gender gender = Gender.valueOf(scanner.nextLine());
        String townName = scanner.nextLine();
        String countryName = scanner.nextLine();
        String email = scanner.nextLine();

        Town town = new Town(townName, new Country(countryName));

        CreateStudentDTO studentDTO = new CreateStudentDTO(firstName, middleName, lastName, EGN, age, gender, town, email);

        studentService.addStudent(studentDTO);
    }

    private void seedNeededData() throws IOException {
        seedService.seedNeededData();
    }
}
