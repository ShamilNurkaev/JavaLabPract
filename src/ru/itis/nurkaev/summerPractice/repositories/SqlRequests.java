/**
 * @nshamil Shamil Nurkaev
 * 11-905
 * Homework 3 (Repository)
 */

package ru.itis.nurkaev.summerPractice.repositories;

public class SqlRequests {

    //language=PostgreSQL
    public static final String SQL_INSERT_STUDENT = "INSERT INTO student (first_name, last_name, age, group_number) VALUES ('%s','%s',%d,%d)";

    //language=PostgreSQL
    public static final String SQL_INSERT_MENTOR = "INSERT INTO mentor (first_name, last_name, subject_id, student_id) VALUES ('%s', '%s', %d, %d)";

    //language=PostgreSQL
    public static final String SQL_SELECT_SUBJECT_ID = "SELECT id FROM subject WHERE title = ('%s')";

    //language=PostgreSQL
    public static final String SQL_INSERT_SUBJECT = "INSERT INTO subject (title) VALUES ('%s')";

    //language=PostgreSQL
    public static final String SQL_SELECT_MENTORS_BY_STUDENTID = "SELECT * FROM mentor m WHERE m.student_id = ";

    //language=PostgreSQL
    public static final String SQL_SELECT_MSUBJECT_BY_SUBJECTID = "SELECT title FROM subject s WHERE s.id = ";

    //language=PostgreSQL
    public static final String SQL_SET_STUDENT_BY_ID = "UPDATE student SET first_name = '%s', last_name = '%s', age = %d, group_number = %d where id = %d";

    //language=PostgreSQL
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM student s LEFT JOIN mentor m ON s.id = m.student_id WHERE s.id = ";

    //language=PostgreSQL
    public static final String SQL_DELETE_MENTORS_BY_STUDENTID = "DELETE FROM mentor WHERE student_id = %d";

    //language=PostgreSQL
    public static final String SQL_SELECT_ALLSTUDENTS_BY_AGE = "SELECT * FROM student WHERE age = ";

    //language=PostgreSQL
    public static final String SQL_SELECT_ALL_STUDENTS = "SELECT " +
            "s.id AS s_id, s.first_name AS s_first_name, s.last_name AS s_last_name, s.age AS age, s.group_number AS group_number, " +
            "m.id AS m_id, m.first_name AS m_first_name, m.last_name AS m_last_name, m.subject_id AS subject_id " +
            "FROM student s FULL OUTER JOIN mentor m ON s.id = m.student_id ORDER BY s.id";
}
