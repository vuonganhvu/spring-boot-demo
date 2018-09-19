package com.higgsup.spring.demo.service;

import com.higgsup.spring.demo.entity.Student;

import java.util.List;

public interface IStudentService {
    void createStudent(Student student);

    Student findOne(Long id);

    List<Student> findAll();

    void updateStudent(Student student);

    void deleteStudent(Long id);
}
