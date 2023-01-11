package SchoolManagementSystem.domain.entities;

import SchoolManagementSystem.domain.entities.base.BaseEntityWithIdLong;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntityWithIdLong {

    @Column
    private String name;

    public Subject(){}

    public Subject(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
