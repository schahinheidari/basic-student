package org.example.sbrdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.sbrdemo.model.entity.Student;
import org.example.sbrdemo.service.StudentServiceIMPL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3005")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentServiceIMPL studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable long id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
}
