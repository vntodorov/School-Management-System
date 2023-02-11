package com.iStudent.model.entity.base;

import javax.persistence.*;


@MappedSuperclass
public abstract class BaseEntityWithIdLong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
