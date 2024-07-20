package com.example.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
// Manages HTTP requests, acting as the entry point for the API
@RestController  // class handles RESTful requests
@RequestMapping("/students")    //base URL path for all endpoints in this controller
@CrossOrigin(origins = "http://localhost:8100")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
