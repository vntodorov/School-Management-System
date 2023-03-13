-- For development!

INSERT INTO countries (name)
VALUES('Bulgaria');

INSERT INTO towns (name, country_id)
VALUES ('Sofia', 1), ('Plovdiv', 1),('Varna', 1), ('Burgas', 1),('Ruse', 1), ('Stara Zagora', 1),('Pleven', 1), ('Sliven', 1),('Dobrich', 1), ('Shumen', 1);

INSERT INTO departments (name)
VALUES ('Administrative and management'), ('Facilities'),('Pupil support and welfare'), ('Specialist and technical');

INSERT INTO marks (mark)
VALUES ('POOR'), ('AVERAGE'), ('GOOD'), ('VERY_GOOD'), ('EXCELLENT');

INSERT INTO students (egn, age, email, first_name, gender, last_name, middle_name, enroll_date, town_id)
VALUES (1234567890, 20, 'vntodorov02@gmail.com', 'Ventsislav', 'M', 'Todorov', 'Nikolaev', '2022-10-10', 1)
