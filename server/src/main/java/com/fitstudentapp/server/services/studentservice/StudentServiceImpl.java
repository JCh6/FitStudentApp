package com.fitstudentapp.server.services.studentservice;

import com.fitstudentapp.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitstudentapp.server.ui.model.response.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        /*Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());


        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }

        studentRepository.save(student);*/
    }

    @Override
    public void deleteStudent(Long id) {
        /*if (!studentRepository.existsById(id))
            throw new IllegalStateException("Student with id: " + id + " does not exists");

        studentRepository.deleteById(id);*/
    }

}
