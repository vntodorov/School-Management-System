package SchoolManagementSystem.service;

import SchoolManagementSystem.models.DTOs.ClubDTO;
import SchoolManagementSystem.models.entities.Club;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repository.ClubRepository;
import SchoolManagementSystem.service.interfaces.ClubService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static SchoolManagementSystem.util.EntityExceptionMessages.CLUB_EXCEPTION;
import static SchoolManagementSystem.util.Validations.*;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    private final ModelMapper mapper;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, ModelMapper mapper) {
        this.clubRepository = clubRepository;
        this.mapper = mapper;
    }

    @Override
    public String addClub(String[] clubData) {
        String clubName = clubData[0];
        String clubDescription = clubData[1];

        ClubDTO clubDTO = new ClubDTO(clubName, clubDescription);

        Club club = mapper.map(clubDTO, Club.class);

        this.clubRepository.save(club);

        return String.format(SUCCESSFULLY_ADDED_CLUB, club);
    }

    @Override
    public String viewClubInformation(String clubName) {
        Optional<Club> club = clubRepository.findByName(clubName);

        if (club.isEmpty()) {
            return String.format(CLUB_DOES_NOT_EXIST, clubName);
        }

        ClubDTO clubToShow = mapper.map(club, ClubDTO.class);

        return clubToShow.toString();
    }

    @Override
    public Club findByName(String clubName) {
        return clubRepository.findByName(clubName).orElseThrow(() -> new EntityException(String.format(CLUB_EXCEPTION, clubName)));
    }
}
