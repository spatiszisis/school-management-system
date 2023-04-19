package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Student;

import java.util.Collection;

public interface StudentService {
    Collection<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Student student, Long id);
    void deleteStudent(Long id);
}
