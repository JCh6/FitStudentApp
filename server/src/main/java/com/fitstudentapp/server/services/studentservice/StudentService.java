package com.fitstudentapp.server.services.studentservice;

import com.fitstudentapp.server.ui.model.response.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void addNewStudent(Student student);
    void deleteStudent(Long id);
}
