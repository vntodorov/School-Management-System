package SchoolManagementSystem.domain.DTOs;

public class StudentBasicInfoDTO {

    private String firstName;

    private String middleName;

    private String lastName;

    private int age;

    private String email;

    public StudentBasicInfoDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + System.lineSeparator()
                + "    Age: " + age + System.lineSeparator()
                + "    Email: " + email;
    }
}
