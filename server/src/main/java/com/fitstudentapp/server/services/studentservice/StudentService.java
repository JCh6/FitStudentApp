package com.fitstudentapp.server.services.studentservice;

import com.fitstudentapp.server.ui.model.request.StudentRequestModel;
import com.fitstudentapp.server.ui.model.response.Student;

public interface StudentService {
    Student getStudent(String id);
    Student addNewStudent(StudentRequestModel student);
}
