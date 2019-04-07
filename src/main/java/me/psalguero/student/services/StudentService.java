package me.psalguero.student.services;

import me.psalguero.student.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student findByName(String name);

    void save(Student student);

    Student delete(Integer id);

    Student update(Student student);

    List<Student> findAll();
}
