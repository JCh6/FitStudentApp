package com.fitstudentapp.server.ui.controller;

import com.fitstudentapp.server.services.studentservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fitstudentapp.server.ui.model.request.StudentRequestModel;
import com.fitstudentapp.server.ui.model.response.Student;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<Student> getStudents(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable String studentId) {
        Student student = studentService.getStudent(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Student> registerNewStudent(@RequestBody StudentRequestModel student) {
        Student newStudent = studentService.addNewStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @PutMapping(path = "/{studentId}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Student> updateStudent() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        //studentService.deleteStudent(id);
    }

}
