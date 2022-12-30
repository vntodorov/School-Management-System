package SchoolManagementSystem.services.interfaces;

import SchoolManagementSystem.domain.entities.Town;

public interface TownService {

    Town findByName(String townName);
}
