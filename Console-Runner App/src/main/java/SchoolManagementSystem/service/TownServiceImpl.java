package SchoolManagementSystem.service;

import SchoolManagementSystem.models.entities.Country;
import SchoolManagementSystem.models.entities.Town;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repository.CountryRepository;
import SchoolManagementSystem.repository.TownRepository;
import SchoolManagementSystem.service.interfaces.CountryService;
import SchoolManagementSystem.service.interfaces.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;

import static SchoolManagementSystem.util.ConsoleMessages.COUNTRY_NAME;
import static SchoolManagementSystem.util.EntityExceptionMessages.TOWN_EXCEPTION;
import static SchoolManagementSystem.util.Validations.*;

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
