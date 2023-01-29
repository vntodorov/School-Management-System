package SchoolManagementSystem.repositories;

import SchoolManagementSystem.domain.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName (String departmentName);
    boolean existsByName(String countryName);
}
