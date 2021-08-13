package com.fitstudentapp.server.services.studentservice;

import com.fitstudentapp.server.exceptions.NotFoundException;
import com.fitstudentapp.server.repository.StudentRepository;
import com.fitstudentapp.server.shared.Utils;
import com.fitstudentapp.server.ui.model.request.StudentRequestModel;
import com.fitstudentapp.server.ui.model.request.StudentUpdateRequestModel;
import com.fitstudentapp.server.ui.model.response.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.fitstudentapp.server.exceptions.Message.NOT_FOUND;

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
    public List<Student> getStudents(int page, int limit) {
        return studentRepository
                .findAllWithPagination(PageRequest.of(page, limit)).getContent();
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

    @Override
    @Transactional
    public Student updateStudent(String id, StudentUpdateRequestModel studentDetails) {
        String newName = studentDetails.getName();
        String newEmail = studentDetails.getEmail();
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND));

        if (newName != null) student.setName(newName);
        if (newEmail != null) student.setEmail(newEmail);

        return student;
    }

    @Override
    public Student deleteStudent(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND));

        studentRepository.deleteById(student.getId());
        return student;
    }
}
