package com.fitstudentapp.server.studentservice;

import com.fitstudentapp.server.models.student.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
}
