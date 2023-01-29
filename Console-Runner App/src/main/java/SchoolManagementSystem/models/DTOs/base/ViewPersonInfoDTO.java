package SchoolManagementSystem.models.DTOs.base;

public abstract class ViewPersonInfoDTO {

    private String firstName;

    private String middleName;

    private String lastName;

    private int age;

    private String email;

    public ViewPersonInfoDTO() {
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
        return "Full name: " + getFullName() + System.lineSeparator()
                + "    Age: " + age + System.lineSeparator()
                + "    Email: " + email;
    }
}
