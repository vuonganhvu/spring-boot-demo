package com.higgsup.spring.demo.controller;

import com.higgsup.spring.demo.entity.Student;
import com.higgsup.spring.demo.service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Created success!");
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return ResponseEntity.ok("Update success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete success");
    }
}
