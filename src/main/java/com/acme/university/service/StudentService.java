package com.acme.university.service;

import com.acme.university.model.Enrollment;
import com.acme.university.model.Student;
import com.acme.university.model.exception.BusinessException;
import com.acme.university.repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) throws BusinessException {
        System.out.println("Creating student");
        try {
            studentRepository.create(student);
            if(student.getEnrollments() != null){
                for (Enrollment enrollment : student.getEnrollments()) {
                    createEnrollment(student, enrollment);
                }
            }
            System.out.println("Created student: "+ student);
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    private void createEnrollment(final Student student, final Enrollment enrollment) throws SQLException {
        System.out.println("Creating enrollment");
        studentRepository.createEnrollment(student, enrollment);
    }

    public List<Student> findAll() throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public Optional<Student> findByID(Long aLong) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public boolean update(Student student) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Student student) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}
