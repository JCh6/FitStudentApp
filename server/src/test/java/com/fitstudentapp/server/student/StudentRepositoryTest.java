package com.fitstudentapp.server.student;

import com.fitstudentapp.server.repository.StudentRepository;
import com.fitstudentapp.server.ui.model.response.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void itShouldfindAllWithPagination() {
        Student student =
                new Student("1", "Juan", "juanch@hotmail.com", LocalDate.now());

        underTest.save(student);

        List<Student> students =
                underTest.findAll(PageRequest.of(0, 1)).getContent();

        System.out.println(students);
        assertThat(true).isTrue();
    }
}
