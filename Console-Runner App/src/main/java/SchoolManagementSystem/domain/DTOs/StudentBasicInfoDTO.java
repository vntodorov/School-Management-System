package SchoolManagementSystem.domain.DTOs;

import SchoolManagementSystem.domain.DTOs.base.ViewPersonInfoDTO;

import static SchoolManagementSystem.constants.Validations.SUCCESSFULLY_VIEW_STUDENT;

public class StudentBasicInfoDTO extends ViewPersonInfoDTO {

    public StudentBasicInfoDTO() {
    }

    @Override
    public String toString() {
        return String.format(SUCCESSFULLY_VIEW_STUDENT, super.toString());
    }
}
