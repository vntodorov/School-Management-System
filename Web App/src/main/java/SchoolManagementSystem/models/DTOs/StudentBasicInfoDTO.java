package SchoolManagementSystem.models.DTOs;

import SchoolManagementSystem.models.DTOs.base.ViewPersonInfoDTO;

import static SchoolManagementSystem.util.Validations.SUCCESSFULLY_VIEW_STUDENT;

public class StudentBasicInfoDTO extends ViewPersonInfoDTO {

    public StudentBasicInfoDTO() {
    }

    @Override
    public String toString() {
        return String.format(SUCCESSFULLY_VIEW_STUDENT, super.toString());
    }
}
