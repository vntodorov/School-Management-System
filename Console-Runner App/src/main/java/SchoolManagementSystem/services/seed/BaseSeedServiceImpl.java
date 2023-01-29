package SchoolManagementSystem.services.seed;

import SchoolManagementSystem.domain.DTOs.AddCountryDTO;
import SchoolManagementSystem.domain.DTOs.AddTownDTO;
import SchoolManagementSystem.domain.DTOs.DepartmentDTO;
import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.domain.entities.Department;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.services.interfaces.DepartmentService;
import SchoolManagementSystem.services.interfaces.CountryService;
import SchoolManagementSystem.services.interfaces.TownService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static SchoolManagementSystem.constants.Paths.*;
import static SchoolManagementSystem.constants.Validations.*;

@Service
public class BaseSeedServiceImpl implements BaseSeedService {

    private final Gson gson;

    private final ModelMapper mapper;

    private final CountryService countryService;

    private final TownService townService;

    private final DepartmentService departmentService;


    @Autowired
    public BaseSeedServiceImpl(Gson gson, ModelMapper mapper, TownService townService, CountryService countryService, DepartmentService departmentService) {
        this.gson = gson;
        this.mapper = mapper;
        this.townService = townService;
        this.countryService = countryService;
        this.departmentService = departmentService;
    }

    @Override
    public void seedBaseCountries() throws IOException {
        if (!countryService.isDataSeeded()) {

            FileReader countryJsonReader = new FileReader(COUNTRIES_JSON_PATH.toFile());

            List<Country> baseCountriesToSeed = Arrays.stream(gson.fromJson(countryJsonReader, AddCountryDTO[].class))
                    .map(c -> mapper.map(c, Country.class))
                    .collect(Collectors.toList());

            countryService.seedCountries(baseCountriesToSeed);
        }
    }

    @Override
    public void seedBaseTowns() throws IOException {
        if (!townService.isDataSeeded()) {

            FileReader townJsonReader = new FileReader(TOWNS_JSON_PATH.toFile());

            Country country = countryService.findByName(BULGARIA_COUNTRY);

            List<Town> baseTownsToSeed = Arrays.stream(gson.fromJson(townJsonReader, AddTownDTO[].class))
                    .map(t -> mapper.map(t, Town.class))
                    .collect(Collectors.toList());
            baseTownsToSeed.forEach(town -> town.setCountry(country));

            townService.seedTowns(baseTownsToSeed);
        }
    }

    @Override
    public void seedBaseDepartments() throws FileNotFoundException {
        if (!departmentService.isDataSeeded()){

            FileReader departmentJsonReader = new FileReader(DEPARTMENT_JSON_PATH.toFile());

            List<Department> departments = Arrays.stream(gson.fromJson(departmentJsonReader, DepartmentDTO[].class))
                    .map(d -> mapper.map(d, Department.class))
                    .toList();

            departmentService.seedDepartments(departments);


        }
    }

    @Override
    @Transactional
    public void seedAllBaseData() throws IOException {
        seedBaseCountries();
        seedBaseTowns();
        seedBaseDepartments();
    }
}
