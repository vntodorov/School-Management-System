package com.iStudent.model.DTOs;

import com.iStudent.model.entity.enums.MarkEnum;

import javax.validation.constraints.NotNull;

public class MarkDTO {

    @NotNull
    private MarkEnum mark;

    public MarkEnum getMark() {
        return mark;
    }

    public void setMark(MarkEnum mark) {
        this.mark = mark;
    }
}
