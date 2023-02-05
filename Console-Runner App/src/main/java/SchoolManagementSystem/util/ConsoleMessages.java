package SchoolManagementSystem.util;

public enum ConsoleMessages {
    ;
    public static final String INSTRUCTION_START_MESSAGE = "Welcome to the School Management System software - console-run app! Here are all commands and their representative number:\n" +
            "1 - Add a new Student in the school.\n" +
            "2 - Add a new Teacher in the school.\n" +
            "3 - Add a new Employee in the school.\n" +
            "4 - Add a new Club in the school.\n" +
            "5 - Add Mark to a Student.\n" +
            "6 - Add Club to a Student.\n" +
            "7 - Add Parent to a Student.\n" +
            "8 - View information for a Student.\n" +
            "9 - View information for a Teacher.\n" +
            "10 - View information for an Employee.\n" +
            "11 - View information for a Club.\n" +
            "0 - End the program.";
    public static final String TYPE_NUMBER = "Type the number of the wanted command: ";


    public static final String ADD_STUDENT_BEGIN = "It's time to add a new student in the school. Please fill up the requested information below:";
    public static final String ADD_TEACHER_BEGIN = "It's time to add a new teacher in the school. Please fill up the requested information below:";
    public static final String ADD_EMPLOYEE_BEGIN = "It's time to add a new employee in the school. Please fill up the requested information below:";
    public static final String ADD_CLUB_BEGIN = "It's time to add a new club in the school. Please fill up the requested information below:";


    public static final String ADD_MARK_TO_STUDENT_BEGIN = "It's time to add a mark to a student in the school. Please fill up the requested information below:";
    public static final String ADD_CLUB_TO_STUDENT_BEGIN = "It's time to add a club to a student in the school. Please fill up the requested information below:";
    public static final String ADD_PARENT_TO_STUDENT_BEGIN = "It's time to add a parent and connect it to a student in the school. Please fill up the requested information for the parent below:";
    public static final String REQUEST_STUDENT_INFO_AFTER = "Now please fill up the requested information about the student you want to connect the parent to:";

    public static final String STUDENT_FIRST_NAME = "Student's first name: ";
    public static final String STUDENT_LAST_NAME = "Student's last name: ";
    public static final String MARK = "Mark [2, 3, 4, 5, 6]: ";


    public static final String PERSON_FIRST_NAME = "First name: ";
    public static final String PERSON_MIDDLE_NAME = "Middle name: ";
    public static final String PERSON_LAST_NAME = "Last name: ";
    public static final String PERSON_EGN = "EGN: ";
    public static final String PERSON_AGE = "Age: ";
    public static final String PERSON_GENDER = "Gender (M or F): ";
    public static final String PERSON_TOWN = "Town: ";
    public static final String PERSON_EMAIL = "Email: ";

    public static final String TEACHER_SUBJECT = "Subject: ";

    public static final String EMPLOYEE_JOB_TITLE = "Job title: ";
    public static final String EMPLOYEE_WORK_HOURS = "Work hours: ";
    public static final String EMPLOYEE_DEPARTMENT = "Department: ";

    public static final String PARENT_PHONE_NUMBER = "Phone number: ";

    public static final String CLUB_NAME = "Club's name: ";
    public static final String CLUB_DESCRIPTION = "Club's description [500 max length]: ";

    public static final String COUNTRY_NAME = "Country's name: ";

}
