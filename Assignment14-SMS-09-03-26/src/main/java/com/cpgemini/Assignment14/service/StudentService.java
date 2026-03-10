package com.cpgemini.Assignment14.service;

import com.cpgemini.Assignment14.entity.Student;
import com.cpgemini.Assignment14.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @PreAuthorize("hasRole('ADMIN')")
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Cacheable(value = "students", key = "#id")
    @PostAuthorize("hasRole('ADMIN') or returnObject.email == authentication.name")
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CachePut(value = "students", key = "#id")
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setCourse(studentDetails.getCourse());
        student.setMarks(studentDetails.getMarks());
        return studentRepository.save(student);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @CacheEvict(value = "students", key = "#id")
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('ADMIN') or #email == authentication.name")
    public Student uploadProfileImage(Long id, String email, MultipartFile file) throws IOException {
        Student student = getStudentById(id);
        student.setProfileImage(file.getBytes());
        return studentRepository.save(student);
    }

    @PreAuthorize("hasRole('ADMIN') or #email == authentication.name")
    public Student uploadAssignment(Long id, String email, MultipartFile file) throws IOException {
        Student student = getStudentById(id);
        student.setAssignmentFile(file.getBytes());
        return studentRepository.save(student);
    }
}
