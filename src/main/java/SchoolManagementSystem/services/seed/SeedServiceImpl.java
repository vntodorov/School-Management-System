package SchoolManagementSystem.services.seed;

import SchoolManagementSystem.domain.entities.Country;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.repositories.CountryRepository;
import SchoolManagementSystem.repositories.TownRepository;
import SchoolManagementSystem.services.interfaces.CountryService;
import SchoolManagementSystem.services.interfaces.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private final TownService townService;

    private final CountryService countryService;

    @Autowired
    public SeedServiceImpl(TownService townService, CountryService countryService) {
        this.townService = townService;
        this.countryService = countryService;
    }

    @Override
    @Transactional
    public void seedNeededData() throws IOException {
        if (!(townService.isDataSeeded() && countryService.isDataSeeded())){

            this.countryService.seedCountries(Files.readAllLines(Path.of("src/main/resources/DataBaseContent/countries.txt"))
                    .stream()
                    .map(Country::new)
                    .collect(Collectors.toList()));

            Country country = countryService.findByName("Bulgaria");

            this.townService.seedTowns(Files.readAllLines(Path.of("src/main/resources/DataBaseContent/towns.txt"))
                    .stream()
                    .map(t -> new Town(t, country))
                    .collect(Collectors.toList()));

        }
    }
}
