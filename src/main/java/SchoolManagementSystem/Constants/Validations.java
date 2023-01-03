package SchoolManagementSystem.Constants;

import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.TownRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

public class Validations {
    public static final String SUCCESSFULLY_ADDED_STUDENT = "You have successfully added a new student in the database! Here are all the details:%n%s";
    public static final String SUCCESSFULLY_ADDED_TOWN = "You have successfully added a new town in the database!";
    public static final String SUCCESSFULLY_ADDED_TEACHER ="You have successfully added a new teacher in the database! Here are all the details:%n%s";
    public static final String TOWN_DOES_NOT_EXIST = "This town doesn't exist. Do you want to add it in the database? [YES or NO]: ";
    public static final String NO_ANSWER = "You selected N0! Please type other command!";
    public static final String BULGARIA_COUNTRY = "Bulgaria";

    @Transactional
    public static boolean checkTown(TownRepository townRepository, CountryRepository countryRepository, String townName){
        boolean doesTownExist = townRepository.existsByName(townName);

        if (!doesTownExist) {
            System.out.print(TOWN_DOES_NOT_EXIST);
            String answer = new Scanner(System.in).nextLine();

            if ("YES".equals(answer)) {
                Country country = countryRepository.findByName(BULGARIA_COUNTRY).orElseThrow();
                Town townToAdd = new Town(townName, country);
                townRepository.save(townToAdd);
            } else {
                return false;
            }
        } else {
            return true;
        }

        System.out.println(SUCCESSFULLY_ADDED_TOWN);
        return true;
    }
}
