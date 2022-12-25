package SchoolManagementSystem.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clubs")
public class Club extends BaseEntityWithIdLong{

    @Column
    private String name;

    @Column(length = 500)
    private String description;

    @ManyToMany(mappedBy = "clubs")
    private Set<Student> students;

    private Club(){
        this.students = new HashSet<>();
    }

    public Club(String name, String description){
        this();
        setName(name);
        setDescription(description);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addStudentToClub(Student student){
        students.add(student);
    }

    public void removeStudentFromClub(Student student){
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

}