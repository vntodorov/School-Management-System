package SchoolManagementSystem.services.interfaces;

import SchoolManagementSystem.domain.entities.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    void seedCountries(List<Country> countries);

    boolean isDataSeeded();

    Country findByName(String countryName);

    String addCountry(String countryName);


}
