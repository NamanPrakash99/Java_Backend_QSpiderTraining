package com.cpgemini.Assignment14.controller;

import com.cpgemini.Assignment14.entity.Student;
import com.cpgemini.Assignment14.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        
        Sort sort = direction.equalsIgnoreCase("desc") ? 
                   Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        
        return ResponseEntity.ok(studentService.getAllStudents(PageRequest.of(page, size, sort)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<Student> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file, Authentication authentication) throws IOException {
        return ResponseEntity.ok(studentService.uploadProfileImage(id, authentication.getName(), file));
    }

    @PostMapping("/{id}/assignment")
    public ResponseEntity<Student> uploadAssignment(@PathVariable Long id, @RequestParam("file") MultipartFile file, Authentication authentication) throws IOException {
        return ResponseEntity.ok(studentService.uploadAssignment(id, authentication.getName(), file));
    }

    @GetMapping("/{id}/profile-image/download")
    public ResponseEntity<byte[]> downloadProfileImage(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"profile_" + id + ".jpg\"")
                .contentType(MediaType.IMAGE_JPEG)
                .body(student.getProfileImage());
    }

    @GetMapping("/{id}/assignment/download")
    public ResponseEntity<byte[]> downloadAssignment(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"assignment_" + id + ".pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(student.getAssignmentFile());
    }
}
