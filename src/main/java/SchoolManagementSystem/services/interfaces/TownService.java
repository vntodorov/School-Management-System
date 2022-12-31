package SchoolManagementSystem.services.interfaces;

import SchoolManagementSystem.domain.entities.Town;

import java.util.List;

public interface TownService {

    void seedTowns(List<Town> towns);

    boolean isDataSeeded();

    Town findByName(String townName);
}
