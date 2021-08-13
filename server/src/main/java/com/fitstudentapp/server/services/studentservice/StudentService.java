package com.fitstudentapp.server.services.studentservice;

import com.fitstudentapp.server.ui.model.request.StudentRequestModel;
import com.fitstudentapp.server.ui.model.request.StudentUpdateRequestModel;
import com.fitstudentapp.server.ui.model.response.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents(int page, int limit);
    Student getStudent(String id);
    Student addNewStudent(StudentRequestModel student);
    Student updateStudent(String id, StudentUpdateRequestModel studentDetails);
    Student deleteStudent(String id);
}
