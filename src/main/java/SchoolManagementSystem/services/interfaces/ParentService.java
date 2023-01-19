package SchoolManagementSystem.services.interfaces;

import SchoolManagementSystem.domain.entities.Parent;

import java.util.List;

public interface ParentService {

    String addParent(List<String> parentData);

    Parent findByFirstNameAndLastName(String firstName, String lastName);
}
