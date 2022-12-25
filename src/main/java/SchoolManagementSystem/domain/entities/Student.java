package SchoolManagementSystem.domain.entities;

import SchoolManagementSystem.domain.enums.Mark;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "students")
public class Student extends BasePersonEntity {

    @ManyToOne
    private Parent parent;

    @ManyToMany
    @JoinTable(name = "students_clubs",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "club_id", referencedColumnName = "id")
    )
    private Set<Club> clubs;

    @ElementCollection(targetClass = Mark.class)
    @JoinTable(name = "students_marks", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "mark", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private List<Mark> marks;

    @Column(name = "enroll_date")
    private LocalDate enrollDate;

    private Student() {
    }

    public Student(String firstName, String middleName, String lastName, int EGN, int age, String email, Town town) {
        super(firstName, middleName, lastName, EGN, age, town, email);
        this.clubs = new HashSet<>();
        this.marks = new ArrayList<>();
        this.enrollDate = LocalDate.now();
    }

    public Set<Club> getClubs() {
        return Collections.unmodifiableSet(clubs);
    }

    public List<Mark> getMarks() {
        return Collections.unmodifiableList(marks);
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

}
