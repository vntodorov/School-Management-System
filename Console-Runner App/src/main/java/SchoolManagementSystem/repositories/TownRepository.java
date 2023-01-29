package SchoolManagementSystem.repositories;

import SchoolManagementSystem.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Optional<Town> findByName(String townName);

    boolean existsByName(String townName);
}
