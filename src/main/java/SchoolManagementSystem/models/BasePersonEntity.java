package SchoolManagementSystem.models;

import SchoolManagementSystem.exceptions.StudentException;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePersonEntity extends BaseEntityWithIdLong {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int EGN;

    @Column(nullable = false)
    private int age;

    protected BasePersonEntity(){}

    protected BasePersonEntity(String firstName, String middleName, String lastName, int EGN, int age) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setEGN(EGN);
        setAge(age);
    }

    protected void setFirstName(String firstName) {
        validateName(firstName);
        this.firstName = firstName;
    }

    protected void setMiddleName(String middleName) {
        validateName(middleName);
        this.middleName = middleName;
    }

    protected void setLastName(String lastName) {
        validateName(lastName);
        this.lastName = lastName;
    }

    protected void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new StudentException("Invalid student name!");
        }
    }

    protected void setEGN(int EGN) {
        int length = 0;
        int temp = 1;
        while (temp <= EGN) {
            length++;
            temp *= 10;
        }
        if (length != 10) {
            throw new StudentException("EGN must be a 10-digit number");
        }
        this.EGN = EGN;
    }

    protected void setAge(int age) {
        if (age <= 0) {
            throw new StudentException("Student age must be a valid number!");
        }
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEGN() {
        return EGN;
    }

    public int getAge() {
        return age;
    }
}
