package com.mouse.tdd.demo.service;

import com.mouse.tdd.demo.dao.StudentRepository;
import com.mouse.tdd.demo.model.Student;
import com.mouse.tdd.demo.vo.AddStudentRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void add(AddStudentRequest request) {
        Student student = new Student("mock-id", request);

        studentRepository.save(student);
    }
}
