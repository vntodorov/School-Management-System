package SchoolManagementSystem.model.entity;

import SchoolManagementSystem.model.entity.base.BaseEntityWithIdLong;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntityWithIdLong {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
