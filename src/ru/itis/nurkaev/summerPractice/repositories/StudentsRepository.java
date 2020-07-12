/**
 * @nshamil Shamil Nurkaev
 * 11-905
 * Homework 3 (Repository)
 */

package ru.itis.nurkaev.summerPractice.repositories;

import ru.itis.nurkaev.summerPractice.models.Student;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student> {
    List<Student> findAllByAge(int age);
}
