package com.fitstudentapp.server.ui.controller;

import com.fitstudentapp.server.services.studentservice.StudentService;
import com.fitstudentapp.server.ui.model.request.StudentRequestModel;
import com.fitstudentapp.server.ui.model.request.StudentUpdateRequestModel;
import com.fitstudentapp.server.ui.model.response.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit
    ) {
        List<Student> students = studentService.getStudents(page, limit);
        return new ResponseEntity<>(students, OK);
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable String studentId) {
        Student student = studentService.getStudent(studentId);
        return new ResponseEntity<>(student, OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Student> registerNewStudent(@Valid @RequestBody StudentRequestModel student) {
        Student newStudent = studentService.addNewStudent(student);
        return new ResponseEntity<>(newStudent, CREATED);
    }

    @PutMapping(path = "/{studentId}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Student> updateStudent(
            @PathVariable String studentId,
            @Valid @RequestBody StudentUpdateRequestModel studentDetails
    ) {
        Student updatedStudent = studentService.updateStudent(studentId, studentDetails);
        return new ResponseEntity<>(updatedStudent, OK);
    }

    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity<Student>  deleteStudent(@PathVariable("studentId") String id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), OK);
    }

}
