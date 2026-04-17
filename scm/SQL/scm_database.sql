CREATE DATABASE student_course_db;
USE student_course_db;

SELECT * FROM courses;
SELECT * FROM students;
DESCRIBE courses;
DESCRIBE students;


SELECT s.id, s.student_name, s.email, s.department, c.course_name, c.course_code
FROM students s
JOIN courses c ON s.course_id = c.id;

SELECT * FROM students;
SELECT * FROM courses;