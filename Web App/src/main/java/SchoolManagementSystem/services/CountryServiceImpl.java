package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.DTOs.AddCountryDTO;
import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.services.interfaces.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static SchoolManagementSystem.constants.EntityExceptionMessages.*;
import static SchoolManagementSystem.constants.Validations.*;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final ModelMapper mapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper mapper) {
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }


    @Override
    public void seedCountries(List<Country> countries) {
        this.countryRepository.saveAll(countries);

    }

    @Override
    public boolean isDataSeeded() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public Country findByName(String countryName) {
        return this.countryRepository.findByName(countryName).orElseThrow(() -> new EntityException(String.format(COUNTRY_EXCEPTION, countryName)));
    }

    @Override
    @Transactional
    public String addCountry(String countryName) {

        if (!checkCountry(countryRepository, countryName)){
            System.out.print(COUNTRY_DOES_NOT_EXIST);
            if (!wantToAdd()){
                return NO_ANSWER;
            }
        } else {
            return COUNTRY_ALREADY_EXISTS;
        }

        AddCountryDTO countryDTO = new AddCountryDTO(countryName);

        countryRepository.save(mapper.map(countryDTO, Country.class));

        return SUCCESSFULLY_ADDED_COUNTRY;
    }
}
