package com.iStudent.model.DTOs;

import com.iStudent.model.DTOs.base.PersonEntityDTO;

public class TeacherDTO extends PersonEntityDTO {

    private SubjectDTO subject;

    public SubjectDTO getSubject() {
        return subject;
    }

    public TeacherDTO setSubject(SubjectDTO subject) {
        this.subject = subject;
        return this;
    }
}
