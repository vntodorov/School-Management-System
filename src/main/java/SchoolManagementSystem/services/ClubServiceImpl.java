package SchoolManagementSystem.services;

import SchoolManagementSystem.repositories.ClubRepository;
import SchoolManagementSystem.services.interfaces.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
}
