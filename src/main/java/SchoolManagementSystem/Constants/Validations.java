package SchoolManagementSystem.constants;

import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.TownRepository;

import java.util.Scanner;

public abstract class Validations {
    public static final String SUCCESSFULLY_ADDED_STUDENT = "You have successfully added a new student in the database! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_ADDED_TEACHER = "You have successfully added a new teacher in the database! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_ADDED_COUNTRY = "You have successfully added a new country in the database!";
    public static final String SUCCESSFULLY_ADDED_TOWN = "You have successfully added a new town in the database!";
    public static final String COUNTRY_DOES_NOT_EXIST = "This country doesn't exist. Do you want to add it in the database? [YES or NO]: ";
    public static final String TOWN_DOES_NOT_EXIST = "This town doesn't exist. Do you want to add it in the database? [YES or NO]: ";
    public static final String COUNTRY_ALREADY_EXISTS = "The country you want to add already exists in the database. Please type other command!";
    public static final String TOWN_ALREADY_EXISTS = "The town you want to add already exists in the database. Please type other command!";
    public static final String NO_ANSWER = "You selected N0! Please type other command!";
    public static final String BULGARIA_COUNTRY = "Bulgaria";

    public static boolean checkTown(TownRepository townRepository, CountryRepository countryRepository, String townName) {
        boolean doesTownExist = townRepository.existsByName(townName);

        if (!doesTownExist) {
            System.out.print(TOWN_DOES_NOT_EXIST);
            return false;
        } else {
            return true;
        }
    }

    public static boolean wantToAdd(){
        String answer = new Scanner(System.in).nextLine();
        return "YES".equals(answer);
    }
}
