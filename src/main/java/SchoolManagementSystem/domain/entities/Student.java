package SchoolManagementSystem.domain.entities;

import SchoolManagementSystem.domain.entities.base.BasePersonEntity;
import SchoolManagementSystem.domain.enums.Gender;
import SchoolManagementSystem.domain.enums.Mark;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "students")
public class Student extends BasePersonEntity {

    @ManyToOne
    private Parent parent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_clubs",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "club_id", referencedColumnName = "id")
    )
    private Set<Club> clubs;

    @ElementCollection(targetClass = Mark.class, fetch = FetchType.LAZY)
    @JoinTable(name = "students_marks", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "mark", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private List<Mark> marks;

    @Column(name = "enroll_date", nullable = false)
    private LocalDate enrollDate;

    private Student() {
    }

    public Student(String firstName, String middleName, String lastName, Gender gender, String EGN, int age, String email, Town town) {
        super(firstName, middleName, lastName, EGN, age, gender, town, email);
        this.clubs = new HashSet<>();
        this.marks = new ArrayList<>();
        setEnrollDate(LocalDate.now());
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

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void addMark(Mark mark){
        marks.add(mark);
    }

    public void addClub(Club club) {
        clubs.add(club);
    }
}
