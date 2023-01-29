package SchoolManagementSystem.constants;

import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.DepartmentRepository;
import SchoolManagementSystem.repositories.TownRepository;

import java.util.Scanner;

public abstract class Validations {

    public static final String EMAIL_VALIDATOR = "^[^\\?=.@,\\/\\\\;'\\[\\]-][A-Za-z\\d_-]+(\\.[A-Za-z\\d_-]+)*@[A-Za-z]+(\\.[A-Za-z\\d-]+)*(\\.[A-Za-z]{2,})$";


    public static final String SUCCESSFULLY_ADDED_STUDENT = "You have successfully added a new student in the database! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_ADDED_TEACHER = "You have successfully added a new teacher in the database! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_ADDED_EMPLOYEE = "You have successfully added a new employee in the database! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_ADDED_CLUB = "You have successfully added a new club in the database! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_ADDED_PARENT = "You have successfully added a parent in the database!";
    public static final String SUCCESSFULLY_ADDED_COUNTRY = "You have successfully added a new country in the database!";
    public static final String SUCCESSFULLY_ADDED_TOWN = "You have successfully added a new town in the database!";


    public static final String SUCCESSFULLY_ADDED_MARK_TO_STUDENT = "You have successfully added mark %d to student %s %s!";
    public static final String SUCCESSFULLY_ADDED_CLUB_TO_STUDENT = "You have successfully added club %s to student %s %s!";
    public static final String SUCCESSFULLY_ADDED_PARENT_TO_STUDENT = "You have successfully connected the parent to student %s %s!";



    public static final String SUCCESSFULLY_VIEW_STUDENT = "You have successfully requested a view to a student! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_VIEW_TEACHER = "You have successfully requested a view to a teacher! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_VIEW_EMPLOYEE = "You have successfully requested a view to an employee! Here are all the details:%n%s";


    public static final String STUDENT_DOES_NOT_EXIST = "Student with first name %s and last name %s doesn't exist.";
    public static final String TEACHER_DOES_NOT_EXIST = "Teacher with first name %s and last name %s doesn't exist.";
    public static final String EMPLOYEE_DOES_NOT_EXIST = "Employee with first name %s and last name %s doesn't exist.";
    public static final String CLUB_DOES_NOT_EXIST = "Club with the name %s doesn't exist.";


    public static final String COUNTRY_DOES_NOT_EXIST = "This country doesn't exist. Do you want to add it in the database? [YES or NO]: ";
    public static final String TOWN_DOES_NOT_EXIST = "This town doesn't exist. Do you want to add it in the database? [YES or NO]: ";
    public static final String COUNTRY_ALREADY_EXISTS = "The country you want to add already exists in the database. Please type other command!";
    public static final String TOWN_ALREADY_EXISTS = "The town you want to add already exists in the database. Please type other command!";
    public static final String NO_ANSWER = "You selected N0! Please type other command!";
    public static final String BULGARIA_COUNTRY = "Bulgaria";


    public static boolean checkTown(TownRepository townRepository, String townName) {
        return townRepository.existsByName(townName);
    }

    public static boolean checkCountry(CountryRepository countryRepository, String countryName) {
        return countryRepository.existsByName(countryName);
    }

    public static boolean checkDepartment(DepartmentRepository departmentRepository, String departmentName) {
        return departmentRepository.existsByName(departmentName);
    }

    public static boolean wantToAdd() {
        String answer = new Scanner(System.in).nextLine();
        return "YES".equals(answer);
    }
}
