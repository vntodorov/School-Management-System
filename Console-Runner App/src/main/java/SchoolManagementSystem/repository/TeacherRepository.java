package SchoolManagementSystem.repository;

import SchoolManagementSystem.models.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByFirstNameAndLastName(String firstName, String lastName);
}
