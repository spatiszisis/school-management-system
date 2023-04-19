package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.model.Response;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<Response> getStudents() {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("students", studentService.getAllStudents()))
                .message("Students retrieved")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getStudent(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("students", studentService.getStudentById(id)))
                .message("Student retrieved")
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
                .message("Student created")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PutMapping()
    public ResponseEntity<Response> updateStudent(@RequestBody Student student, @RequestBody Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("students", studentService.updateStudent(student, id)))
                .message("Student updated")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping()
    public ResponseEntity<Response> deleteStudent(@RequestBody Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("students", studentService.deleteStudent(id)))
                .message("Student updated")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }
}
