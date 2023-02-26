package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BasePersonEntity;
import com.iStudent.model.entity.enums.MarkEnum;

import javax.persistence.*;

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

    @ElementCollection(targetClass = MarkEnum.class, fetch = FetchType.LAZY)
    @JoinTable(name = "students_marks", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "mark", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<MarkEnum> marks;

    @Column(name = "enroll_date", nullable = false)
    private LocalDate enrollDate;

    public Student() {
        this.clubs = new HashSet<>();
        this.marks = new ArrayList<>();
    }

    public Set<Club> getClubs() {
        return Collections.unmodifiableSet(clubs);
    }

    public List<MarkEnum> getMarks() {
        return Collections.unmodifiableList(marks);
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void addMark(MarkEnum markEnum) {
        marks.add(markEnum);
    }

    public void addClub(Club club) {
        clubs.add(club);
    }

    public void removeClub(Club club) {
        clubs.remove(club);
    }

    public void removeParent() {
        this.parent = null;
    }
}
