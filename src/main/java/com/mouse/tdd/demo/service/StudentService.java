package com.mouse.tdd.demo.service;

import com.mouse.tdd.demo.dao.ClassRepository;
import com.mouse.tdd.demo.dao.StudentRepository;
import com.mouse.tdd.demo.model.Student;
import com.mouse.tdd.demo.vo.AddStudentRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    public StudentService(StudentRepository studentRepository, ClassRepository classRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }

    public void add(AddStudentRequest request) {
        if (!classRepository.exists(request.getClassId())) throw new IllegalArgumentException("Unknown classId");

        studentRepository.save(new Student("mock-id", request));
    }
}
