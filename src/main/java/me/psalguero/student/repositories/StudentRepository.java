package me.psalguero.student.repositories;

import me.psalguero.student.entities.Student;
import me.psalguero.student.types.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByFirstName(String name);

    Student findByGender(Gender gender);
}
