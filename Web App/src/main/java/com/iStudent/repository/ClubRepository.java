package com.iStudent.repository;

import com.iStudent.model.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {


    Optional<Club> findByName(String clubName);
}
