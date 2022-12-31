package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.services.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
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
        return this.countryRepository.findByName(countryName).orElseThrow(() -> new EntityException("Country with the name " + countryName + " does not exist!"));
    }
}
