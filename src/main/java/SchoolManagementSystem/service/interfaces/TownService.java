package SchoolManagementSystem.service.interfaces;

import SchoolManagementSystem.models.entities.Town;

import java.util.List;

public interface TownService {

    void seedTowns(List<Town> towns);

    boolean isDataSeeded();

    Town findByName(String townName);

    String addTown(String townName);
}
