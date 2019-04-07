package me.psalguero.student.services.impl;

import me.psalguero.student.entities.Student;
import me.psalguero.student.repositories.StudentRepository;
import me.psalguero.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findByName(String name) {
        Optional<Student> findByName = Optional
                .ofNullable(studentRepository.findByFirstName(name));

        if(findByName.isPresent()) {
            return findByName.get();
        }

        return null;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student delete(Integer id) {
        Optional<Student> find = studentRepository.findById(id);

        if(find.isPresent()) {
            studentRepository.delete(find.get());
            return find.get();
        }

        return null;
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
