package com.fitstudentapp.server.repository;

import com.fitstudentapp.server.ui.model.response.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository
        extends JpaRepository<Student, String> {
}
