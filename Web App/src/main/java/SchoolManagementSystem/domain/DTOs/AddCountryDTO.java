package SchoolManagementSystem.domain.DTOs;

public class AddCountryDTO {

    private String name;

    public AddCountryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
