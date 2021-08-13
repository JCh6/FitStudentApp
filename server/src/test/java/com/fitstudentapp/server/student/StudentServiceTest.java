package com.fitstudentapp.server.student;

import com.fitstudentapp.server.repository.StudentRepository;
import com.fitstudentapp.server.services.studentservice.StudentService;
import com.fitstudentapp.server.services.studentservice.StudentServiceImpl;
import com.fitstudentapp.server.shared.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class StudentServiceTest {

    private StudentService underTest;

    @Mock
    private StudentRepository studentRepository;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentServiceImpl(new Utils(), studentRepository);
    }

    @AfterEach
    void tearDown () throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetStudents() {
        try {
            //underTest.getStudents(0, 1);
            underTest.deleteStudent("1111");
        } catch(Exception e) {
            System.out.println(e);
        }
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