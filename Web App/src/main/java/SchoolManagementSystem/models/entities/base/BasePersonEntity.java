package SchoolManagementSystem.models.entities.base;

import SchoolManagementSystem.models.entities.Town;
import SchoolManagementSystem.models.enums.Gender;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class BasePersonEntity extends BaseEntityWithIdLong {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String EGN;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Town town;

    @Column
    private String email;

    protected BasePersonEntity() {
    }

    protected BasePersonEntity(String firstName, String middleName, String lastName, String EGN, int age, Gender gender, Town town, String email) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setEGN(EGN);
        setAge(age);
        setGender(gender);
        setTown(town);
        setEmail(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public Gender getGender() {
        return gender;
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

    public String getEGN() {
        return EGN;
    }

    public int getAge() {
        return age;
    }

    public Town getTown() {
        return town;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        info.append("First name: ").append(firstName).append(System.lineSeparator())
                .append("Middle name: ").append(middleName).append(System.lineSeparator())
                .append("Last name: ").append(lastName).append(System.lineSeparator())
                .append("EGN: ").append(EGN).append(System.lineSeparator())
                .append("Age: ").append(age).append(System.lineSeparator())
                .append("Gender: ").append(gender).append(System.lineSeparator())
                .append("Town: ").append(town.getName()).append(System.lineSeparator())
                .append("Email: ").append(email);

        return info.toString();

    }
}
