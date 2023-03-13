package com.iStudent.model.entity;

import com.iStudent.model.entity.base.BaseEntityWithIdLong;
import com.iStudent.model.entity.enums.MarkEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class Mark extends BaseEntityWithIdLong {

    @Enumerated(EnumType.STRING)
    private MarkEnum mark;

    public MarkEnum getMark() {
        return mark;
    }

    public void setMark(MarkEnum mark) {
        this.mark = mark;
    }
}
