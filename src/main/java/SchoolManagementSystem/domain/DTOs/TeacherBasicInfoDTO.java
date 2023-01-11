package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.DTOs.base.ViewPersonInfoDTO;

import static SchoolManagementSystem.constants.Validations.SUCCESSFULLY_VIEW_TEACHER;

public class TeacherBasicInfoDTO extends ViewPersonInfoDTO {

    private SubjectDTO subject;

    public TeacherBasicInfoDTO() {
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format(SUCCESSFULLY_VIEW_TEACHER,
                super.toString() + System.lineSeparator()
                        + "    Subject: " + subject.getName());
    }
}
