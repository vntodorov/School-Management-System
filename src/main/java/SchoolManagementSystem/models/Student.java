package SchoolManagementSystem.models;

import SchoolManagementSystem.exceptions.StudentException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "students")
public class Student extends BasePersonEntity {
    @Column
    private String email;

    @ManyToOne
    private Town town;

    @ManyToMany
    @JoinTable(name = "students_clubs",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "club_id", referencedColumnName = "id")
    )
    private Set<Club> clubs;

    @Column
    private List<Integer> marks;

    @Column(name = "enroll_date")
    private LocalDate enrollDate;

    private Student() {
    }

    public Student(String firstName, String middleName, String lastName, int EGN, int age, String email, Town town) {
        super(firstName, middleName, lastName, EGN, age);
        this.email = email;
        this.town = town;
        this.clubs = new HashSet<>();
        this.marks = new ArrayList<>();
        this.enrollDate = LocalDate.now();
    }

    public String getEmail() {
        return email;
    }

    public Town getTown() {
        return town;
    }

    public Set<Club> getClubs() {
        return Collections.unmodifiableSet(clubs);
    }

    public List<Integer> getMarks() {
        return Collections.unmodifiableList(marks);
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void addMark(int mark){
        if (mark < 2 || mark > 6){
            throw new StudentException("Invalid mark - " + mark + "! Marks are from the range [2-6]");
        }
        marks.add(mark);
    }
}
