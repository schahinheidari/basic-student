package org.example.sbrdemo.repository;

import org.example.sbrdemo.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
