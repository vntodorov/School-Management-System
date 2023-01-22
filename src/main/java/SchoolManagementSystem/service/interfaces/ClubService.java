package SchoolManagementSystem.service.interfaces;

import SchoolManagementSystem.models.entities.Club;

public interface ClubService {
    String addClub(String[] clubData);

    String viewClubInformation(String clubName);

    Club findByName(String clubName);
}
