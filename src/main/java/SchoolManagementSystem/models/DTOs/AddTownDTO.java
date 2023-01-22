package SchoolManagementSystem.models.DTOs;

public class AddTownDTO {

    private String name;

    private AddCountryDTO country;

    public AddTownDTO(String name, AddCountryDTO country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddCountryDTO getCountry() {
        return country;
    }

    public void setCountry(AddCountryDTO country) {
        this.country = country;
    }
}
