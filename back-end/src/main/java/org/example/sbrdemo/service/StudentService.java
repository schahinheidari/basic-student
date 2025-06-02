package org.example.sbrdemo.service;

import lombok.RequiredArgsConstructor;
import org.example.sbrdemo.exceptions.ResourceNotFoundException;
import org.example.sbrdemo.exceptions.StudentAlreadyExistsException;
import org.example.sbrdemo.model.entity.Student;
import org.example.sbrdemo.repository.StudentDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServiceIMPL{

    private final StudentDao studentDao;
    @Override
    public Student addStudent(Student student) {
        if (studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistsException(" Already exists student with email: " + student.getEmail());
        }
        return studentDao.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No student found with the ID : " + id));
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentDao.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentDao.save(st);
        }).orElseThrow(()-> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.findById(id).ifPresentOrElse(studentDao::delete, () -> {
            throw new ResourceNotFoundException("Student not found");
        });
    }

    private boolean studentAlreadyExists(String email) {
        return studentDao.findByEmail(email).isPresent();
    }
}
