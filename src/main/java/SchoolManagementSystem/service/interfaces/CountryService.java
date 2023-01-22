package SchoolManagementSystem.service.interfaces;

import SchoolManagementSystem.models.entities.Country;

import java.util.List;

public interface CountryService {

    void seedCountries(List<Country> countries);

    boolean isDataSeeded();

    Country findByName(String countryName);

    String addCountry(String countryName);


}
