package SchoolManagementSystem.repositories;

import SchoolManagementSystem.domain.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByName(String countryName);

    boolean existsByName(String countryName);
}
