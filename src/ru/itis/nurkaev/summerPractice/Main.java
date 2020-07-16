/**
 * @nshamil Shamil Nurkaev
 * 11-905
 * Homework 3 (Repository)
 */

package ru.itis.nurkaev.summerPractice;

import ru.itis.nurkaev.summerPractice.models.Mentor;
import ru.itis.nurkaev.summerPractice.models.Student;
import ru.itis.nurkaev.summerPractice.repositories.StudentsRepository;
import ru.itis.nurkaev.summerPractice.repositories.StudentsRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String URL = "jdbc:postgresql://localhost:5432/java_lab_pract_2020";
    public static final String USER = "postgres";
    public static final String PASSWORD = "9aw25pxj";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        StudentsRepository studentsRepository = new StudentsRepositoryJdbcImpl(connection);

        /*test findAllByAge*/
        List<Student> students = studentsRepository.findAllByAge(19);
        for (Student student : students) {
            System.out.println(student);
        }

        /*test findAll*/
        List<Student> students1 = studentsRepository.findAll();
        for (Student student : students1) {
            System.out.println(student);
        }

        /*test findByid*/
        System.out.println(studentsRepository.findById(2L));

        /*test save*/
        List<Mentor> mentors = new ArrayList<>();
        Student student = new Student(null, "Никита", "Гвоздев", 19, 904, mentors);
        mentors.add(new Mentor(null, "Андрей", "Райгородский", "Discrete math", student));
        mentors.add(new Mentor(null, "Илон", "Маск", "IT", student));
        studentsRepository.save(student);
        // after saving to the DB, the student and their mentors have a unique ID
        System.out.println(student);

        /*test update*/
        student.setFirstName("Дмитрий");
        student.setLastName("Железнов");
        student.setGroupNumber(905);
        List<Mentor> mentors1 = new ArrayList<>();
        mentors1.add(new Mentor(null, "Алексей", "Савватеев", "Math analysis", student));
        student.setMentors(mentors1);
        studentsRepository.update(student);
        System.out.println(studentsRepository.findById(student.getId()));

        connection.close();

    }
}