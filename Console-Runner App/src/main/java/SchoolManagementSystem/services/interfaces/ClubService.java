package SchoolManagementSystem.services.interfaces;

import SchoolManagementSystem.domain.entities.Club;

public interface ClubService {
    String addClub(String[] clubData);

    String viewClubInformation(String clubName);

    Club findByName(String clubName);
}
