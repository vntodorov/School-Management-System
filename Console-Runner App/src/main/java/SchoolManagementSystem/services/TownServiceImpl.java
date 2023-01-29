package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.DTOs.AddCountryDTO;
import SchoolManagementSystem.domain.DTOs.AddTownDTO;
import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.TownRepository;
import SchoolManagementSystem.services.interfaces.CountryService;
import SchoolManagementSystem.services.interfaces.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;

import static SchoolManagementSystem.constants.ConsoleMessages.COUNTRY_NAME;
import static SchoolManagementSystem.constants.EntityExceptionMessages.TOWN_EXCEPTION;
import static SchoolManagementSystem.constants.Validations.*;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    private final CountryRepository countryRepository;

    private final CountryService countryService;

    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, CountryRepository countryRepository, CountryService countryService, ModelMapper mapper) {
        this.townRepository = townRepository;
        this.countryRepository = countryRepository;
        this.countryService = countryService;
        this.mapper = mapper;
    }

    @Override
    public void seedTowns(List<Town> towns) {
        this.townRepository.saveAll(towns);
    }

    @Override
    public boolean isDataSeeded() {
        return this.townRepository.count() > 0;
    }

    @Override
    public Town findByName(String townName) {
        return this.townRepository.findByName(townName).orElseThrow(() -> new EntityException(String.format(TOWN_EXCEPTION, townName)));
    }

    @Override
    @Transactional
    public String addTown(String townName) {

        if (!checkTown(townRepository, townName)) {
            System.out.print(TOWN_DOES_NOT_EXIST);
            if (!wantToAdd()) {
                return NO_ANSWER;
            }
        } else {
            return TOWN_ALREADY_EXISTS;
        }


        System.out.print(COUNTRY_NAME);
        String countryName = new Scanner(System.in).nextLine();

        String addCountryResult = countryService.addCountry(countryName);

        if (addCountryResult.equals(SUCCESSFULLY_ADDED_COUNTRY)) {
            System.out.println(addCountryResult);
        } else if (addCountryResult.equals(NO_ANSWER)) {
            return NO_ANSWER;
        }

        Country country = countryRepository.findByName(countryName).orElseThrow();
        Town town = new Town(townName, country);

        townRepository.save(town);

        return SUCCESSFULLY_ADDED_TOWN;
    }
}
