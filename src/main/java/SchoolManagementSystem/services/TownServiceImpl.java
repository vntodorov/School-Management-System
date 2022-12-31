package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.TownRepository;
import SchoolManagementSystem.services.interfaces.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void seedTowns(List<Town> towns) {
        this.townRepository.saveAll(towns);
    }

    @Override
    public boolean isDataSeeded() {
        return this.townRepository.count() > 0;
    }

    @Override
    public Town findByName(String townName) {
        return this.townRepository.findByName(townName).orElseThrow(() -> new EntityException("Cannot find a town with name " + townName));
    }
}
