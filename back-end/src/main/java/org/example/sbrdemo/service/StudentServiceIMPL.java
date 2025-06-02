package org.example.sbrdemo.service;

import org.example.sbrdemo.model.entity.Student;

import java.util.List;

public interface StudentServiceIMPL {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Student student, Long id);
    void deleteStudent(Long id);
}
