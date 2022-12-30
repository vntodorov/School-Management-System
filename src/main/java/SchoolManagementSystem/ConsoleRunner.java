package SchoolManagementSystem;

import SchoolManagementSystem.domain.DTOs.CreateStudentDTO;
import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final StudentService studentService;

    @Autowired
    public ConsoleRunner(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String middleName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int EGN = Integer.parseInt(scanner.nextLine());
        int age = Integer.parseInt(scanner.nextLine());
        Gender gender = Gender.valueOf(scanner.nextLine());
        String townName = scanner.nextLine();
        String countryName = scanner.nextLine();
        String email = scanner.nextLine();

        Town town = new Town(townName, new Country(countryName));

        CreateStudentDTO studentDTO = new CreateStudentDTO(firstName, middleName, lastName, EGN, age, gender, town, email);

        studentService.addStudent(studentDTO);


    }
}
