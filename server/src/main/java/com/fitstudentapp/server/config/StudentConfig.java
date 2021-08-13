package com.fitstudentapp.server.config;

import com.fitstudentapp.server.models.student.Student;
import com.fitstudentapp.server.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "marian.lopez@gmail.com",
                    LocalDate.of(2000, Month.JULY, 5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex.burgos@gmail.com",
                    LocalDate.of(2002, Month.JULY, 1)
            );

            repository.saveAll(List.of(mariam, alex));
        };
    }

}
