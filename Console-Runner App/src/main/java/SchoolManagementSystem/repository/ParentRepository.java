package SchoolManagementSystem.repository;

import SchoolManagementSystem.models.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Optional<Parent> findByFirstNameAndLastName(String firstName, String lastName);
}
