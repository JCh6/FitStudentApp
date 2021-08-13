package com.fitstudentapp.server.student;

import com.fitstudentapp.server.repository.StudentRepository;
import com.fitstudentapp.server.ui.model.response.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    private static Student s;
    @Autowired
    private StudentRepository underTest;

    @BeforeAll
    static void setUp() {
        s = new Student(
                "1",
                "Juan",
                "juanch@hotmail.com",
                LocalDate.now()
        );
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindWithPagination() {
        underTest.save(s);

        List<Student> students =
                underTest.findAll(PageRequest.of(0, 1)).getContent();

        assertThat(students.stream().count()).isEqualTo(1);
        assertThat(students.get(0).getEmail()).isEqualTo(s.getEmail());
    }

    @Test
    void itShouldNotFindWithPagination() {
        List<Student> students =
                underTest.findAll(PageRequest.of(0, 1)).getContent();

        assertThat(students.stream().count()).isEqualTo(0);
    }
}
