package me.psalguero.student.data;

import me.psalguero.student.entities.Parent;
import me.psalguero.student.entities.Role;
import me.psalguero.student.entities.Student;
import me.psalguero.student.entities.User;
import me.psalguero.student.repositories.StudentRepository;
import me.psalguero.student.repositories.UserRepository;
import me.psalguero.student.services.StudentService;
import me.psalguero.student.types.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DBUserInit implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DBUserInit.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setRole("ADMIN");

        User user = new User();
        user.setActive(1);
        user.setEmail("patrick.salguero.developer@gmail.com");
        user.setName("psalguero");
        user.setLastname("Salguero Avalos");
        user.setPassword(passwordEncoder.encode("developer"));
        user.setRoles(new HashSet<>(Arrays.asList(role)));

        userRepository.save(user);

        Parent parent = new Parent();
        parent.setFirstName("Father name");
        parent.setLastName("Father lastname");
        parent.setGender(Gender.MASCULINE);
        parent.setMiddleName("Father middlename");

        Student student = new Student();
        student.setFirstName("Luis");
        student.setMiddleName("Middlename");
        student.setLastName("Lastname");
        student.setGender(Gender.MASCULINE);
        student.setParent(new HashSet<>(Arrays.asList(parent)));

        studentService.save(student);
    }
}
