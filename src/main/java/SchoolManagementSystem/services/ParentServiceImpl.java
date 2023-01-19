package SchoolManagementSystem.services;

import SchoolManagementSystem.domain.DTOs.AddParentDTO;
import SchoolManagementSystem.domain.entities.Parent;
import SchoolManagementSystem.domain.entities.Town;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.exceptions.EntityException;
import SchoolManagementSystem.repositories.ParentRepository;
import SchoolManagementSystem.services.interfaces.ParentService;
import SchoolManagementSystem.services.interfaces.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static SchoolManagementSystem.constants.EntityExceptionMessages.CLUB_EXCEPTION;
import static SchoolManagementSystem.constants.EntityExceptionMessages.PARENT_EXCEPTION;
import static SchoolManagementSystem.constants.Validations.*;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;

    @Autowired
    public ParentServiceImpl(ParentRepository parentRepository, TownService townService, ModelMapper modelMapper) {
        this.parentRepository = parentRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public String addParent(List<String> parentData) {
        String firstName = parentData.get(0);
        String middleName = parentData.get(1);
        String lastName = parentData.get(2);
        String EGN = parentData.get(3);
        int age = Integer.parseInt(parentData.get(4));
        Gender gender = Gender.valueOf(parentData.get(5));
        String townName = parentData.get(6);
        String email = parentData.get(7);
        String phoneNumber = parentData.get(8);

        AddParentDTO parentDTO;

        String resultOfAddingTown = townService.addTown(townName);

        if (resultOfAddingTown.equals(NO_ANSWER)) {
            return NO_ANSWER;
        } else if (resultOfAddingTown.equals(SUCCESSFULLY_ADDED_TOWN)) {
            System.out.println(resultOfAddingTown);
        }

        Town town = townService.findByName(townName);

        try {
            parentDTO = new AddParentDTO(firstName, middleName, lastName, EGN, age, gender, town, email, phoneNumber);
        } catch (EntityException e) {
            return e.getMessage();
        }

        Parent parent = modelMapper.map(parentDTO, Parent.class);

        parentRepository.save(parent);

        return SUCCESSFULLY_ADDED_PARENT;
    }

    @Override
    public Parent findByFirstNameAndLastName(String firstName, String lastName) {
        return this.parentRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(() -> new EntityException(String.format(PARENT_EXCEPTION, firstName, lastName)));
    }
}
