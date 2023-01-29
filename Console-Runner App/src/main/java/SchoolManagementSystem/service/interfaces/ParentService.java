package SchoolManagementSystem.service.interfaces;

import SchoolManagementSystem.models.entities.Parent;

import java.util.List;

public interface ParentService {

    String addParent(List<String> parentData);

    Parent findByFirstNameAndLastName(String firstName, String lastName);
}
