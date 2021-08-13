package com.fitstudentapp.server.student;

import com.fitstudentapp.server.repository.StudentRepository;
import com.fitstudentapp.server.services.studentservice.StudentService;
import com.fitstudentapp.server.services.studentservice.StudentServiceImpl;
import com.fitstudentapp.server.shared.Utils;
import com.fitstudentapp.server.ui.model.response.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class StudentServiceTest {

    private StudentService underTest;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new StudentServiceImpl(new Utils(), studentRepository);
    }

    @Test
    void canGetStudents() {
        OngoingStubbing<Page<Student>> mockFindAll =
                when(studentRepository.findAll(any(Pageable.class)));

        mockFindAll.thenReturn(
                new PageImpl<>(Collections.singletonList(new Student()))
        );

        underTest.getStudents(0, 1);
    }

    @Test
    @Disabled
    void getStudent() {
    }

    @Test
    @Disabled
    void addNewStudent() {
    }

    @Test
    @Disabled
    void updateStudent() {
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}