package com.iStudent.web;

import com.iStudent.model.DTOs.ClubDTO;
import com.iStudent.model.DTOs.StudentDTO;
import com.iStudent.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public ResponseEntity<List<ClubDTO>> getAllClubs() {
        return ResponseEntity.
                ok(clubService.getAllClubs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDTO> getClubById(@PathVariable("id") Long clubId) {
        Optional<ClubDTO> club = this.clubService.getClubById(clubId);

        if (club.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();

        } else {
            return ResponseEntity
                    .ok(club.get());

        }
    }

    @PostMapping
    public ResponseEntity<ClubDTO> addClub(@Valid @RequestBody ClubDTO clubDTO,
                                           UriComponentsBuilder uriComponentsBuilder) {

        long newClubId = clubService.addClub(clubDTO);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/clubs/{id}")
                        .build(newClubId))
                .build();
    }

    @PostMapping("/{clubId}/student/{studentId}")
    public ResponseEntity<StudentDTO> addClubToStudent(@PathVariable("clubId") Long clubId, @PathVariable("studentId") Long studentId) {
        Optional<StudentDTO> optionalDesiredStudent = clubService.addClubToStudent(clubId, studentId);

        if (optionalDesiredStudent.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        } else {
            return ResponseEntity
                    .ok(optionalDesiredStudent.get());
        }

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ClubDTO> changeClubName(@Valid @RequestBody ClubDTO clubDTO,
                                                  @PathVariable("id") Long id) {

        ClubDTO club = clubService.changeClubName(id, clubDTO);

        if (club == null) {
            return ResponseEntity.
                    notFound().
                    build();
        } else {
            return ResponseEntity.
                    ok(club);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClubDTO> deleteClubById(@PathVariable("id") Long clubId) {
        this.clubService.deleteClubById(clubId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
