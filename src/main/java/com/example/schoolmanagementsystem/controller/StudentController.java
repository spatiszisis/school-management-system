package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.model.Response;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<Response> getStudents() {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("students", studentService.getAllStudents()))
                .message("Students retrieved successfully!")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getStudent(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("student", studentService.getStudentById(id)))
                .message("Student retrieved successfully!")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping()
    public ResponseEntity<Response> createStudent(@RequestBody @Valid Student student) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("students", studentService.createStudent(student)))
                .message("Student created successfully!")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PutMapping()
    public ResponseEntity<Response> updateStudent(@RequestBody Student student, @RequestBody Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("student", studentService.updateStudent(student, id)))
                .message("Student updated successfully!")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteStudent(@RequestBody Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
    }
}
