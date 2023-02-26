package com.iStudent.service;

import com.iStudent.model.DTOs.ClubDTO;
import com.iStudent.model.DTOs.StudentDTO;
import com.iStudent.model.entity.Club;
import com.iStudent.model.entity.Student;
import com.iStudent.repository.ClubRepository;
import com.iStudent.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    private final StudentRepository studentRepository;

    private final ModelMapper mapper;

    @Autowired
    public ClubService(ClubRepository clubRepository, StudentRepository studentRepository, ModelMapper mapper) {
        this.clubRepository = clubRepository;
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public List<ClubDTO> getAllClubs() {
        return clubRepository.
                findAll().
                stream().
                map(this::mapToClubDTO).
                toList();
    }

    private ClubDTO mapToClubDTO(Club club) {
        return mapper.map(club, ClubDTO.class);
    }

    public Optional<ClubDTO> getClubById(Long clubId) {
        return clubRepository.
                findById(clubId).
                map(this::mapToClubDTO);
    }

    @Transactional
    public void deleteClubById(Long clubId) {
        Optional<Club> optionalClub = clubRepository.findById(clubId);


        if (optionalClub.isPresent()){
            Club club = optionalClub.get();
            Optional<List<Student>> studentsOptional = studentRepository.findByClubs(club);
            for (Student student : studentsOptional.get()){
                student.removeClub(club);
            }
        }

        clubRepository.deleteById(clubId);
    }

    public long addClub(ClubDTO clubDTO) {
        Club club = mapper.map(clubDTO, Club.class);

        clubRepository.save(club);

        return club.getId();
    }

    @Transactional
    public Optional<StudentDTO> addClubToStudent(Long clubId, Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Club> optionalClub = clubRepository.findById(clubId);

        if (optionalStudent.isPresent() && optionalClub.isPresent()) {
            Student student = optionalStudent.get();
            Club club = optionalClub.get();

            student.addClub(club);
            studentRepository.save(student);

            return studentRepository.findById(studentId).map(s -> mapper.map(s, StudentDTO.class));

        } else {
            return Optional.empty();
        }


    }

    public ClubDTO changeClubName(Long id, ClubDTO clubDTO) {
        Optional<Club> optionalClub = clubRepository.findById(id);

        if (optionalClub.isPresent()) {
            Club club = optionalClub.get();
            club.setName(clubDTO.getName());

            clubRepository.save(club);
            return mapToClubDTO(club);
        }

        return null;
    }
}
