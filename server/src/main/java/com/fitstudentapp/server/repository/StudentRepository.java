package com.fitstudentapp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fitstudentapp.server.ui.model.response.Student;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, String> {
}
