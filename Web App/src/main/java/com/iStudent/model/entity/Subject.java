package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BaseEntityWithIdLong;
import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntityWithIdLong {

    @Column(unique = true, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
