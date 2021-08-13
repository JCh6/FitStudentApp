package com.fitstudentapp.server.repository;

import com.fitstudentapp.server.ui.model.response.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository
        extends JpaRepository<Student, String> {

    @Query(value = "SELECT s FROM Student s")
    Page<Student> findAllWithPagination(Pageable pageable);
}
