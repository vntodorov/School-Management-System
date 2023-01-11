package SchoolManagementSystem.domain.DTOs;

public class SubjectDTO {

    private String name;

    public SubjectDTO(String name) {
        this.name = name;
    }

    public SubjectDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
