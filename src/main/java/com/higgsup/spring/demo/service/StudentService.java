package com.higgsup.spring.demo.service;

import com.higgsup.spring.demo.entity.Student;
import com.higgsup.spring.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findOne(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void updateStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if(optionalStudent.isPresent()){
            Student oldStudent = optionalStudent.get();
            oldStudent.setName(student.getName());
            oldStudent.setPassportNumber(student.getPassportNumber());
            studentRepository.save(oldStudent);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentRepository.delete(student);
        }
    }
}
