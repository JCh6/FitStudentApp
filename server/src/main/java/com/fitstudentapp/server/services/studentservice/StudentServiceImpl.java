package com.fitstudentapp.server.services.studentservice;

import com.fitstudentapp.server.exceptions.NotFoundException;
import com.fitstudentapp.server.repository.StudentRepository;
import com.fitstudentapp.server.shared.Utils;
import com.fitstudentapp.server.ui.model.request.StudentRequestModel;
import com.fitstudentapp.server.ui.model.response.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.fitstudentapp.server.exceptions.Message.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    Utils utils;

    @Autowired
    public StudentServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public Student getStudent(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND));
    }

    @Override
    public Student addNewStudent(StudentRequestModel student) {
        String studentId = utils.generateStudentId();
        return studentRepository.save(new Student(studentId, student));
    }
}
