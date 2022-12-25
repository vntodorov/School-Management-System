package SchoolManagementSystem.domain.entities;

import SchoolManagementSystem.exceptions.EntityException;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import java.util.regex.Pattern;

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

    @ManyToOne
    private Town town;

    @Column
    private String email;

    protected BasePersonEntity(){}

    protected BasePersonEntity(String firstName, String middleName, String lastName, int EGN, int age, Town town, String email) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setEGN(EGN);
        setAge(age);
        setTown(town);
        setEmail(email);
    }

    protected void setEmail(String email) {
        String emailValidator = "^[^\\?=.@,\\/\\\\;'\\[\\]-][A-Za-z\\d_-]+(\\.[A-Za-z\\d_-]+)*@[^-][A-Za-z\\d-]+(\\.[A-Za-z\\d-]+)*(\\.[A-Za-z]{2,})$";
        if (Pattern.compile(emailValidator).matcher(email).matches()){
            throw new EntityException("Invalid email!");
        }
        this.email = email;
    }

    protected void setEGN(int EGN) {
        int length = 0;
        int temp = 1;
        while (temp <= EGN) {
            length++;
            temp *= 10;
        }
        if (length != 10) {
            throw new EntityException("EGN must be a 10-digit number");
        }
        this.EGN = EGN;
    }

    protected void setAge(int age) {
        if (age <= 0) {
            throw new EntityException("Age must be a valid number!");
        }
        this.age = age;
    }

    protected void setTown(Town town) {
        this.town = town;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Town getTown() {
        return town;
    }

    public String getEmail() {
        return email;
    }
}
