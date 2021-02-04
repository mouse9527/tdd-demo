package com.mouse.tdd.demo.controller;

import com.mouse.tdd.demo.service.StudentService;
import com.mouse.tdd.demo.vo.AddStudentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController {
    @Resource
    private StudentService studentService;

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody AddStudentRequest request) {
        studentService.add(request);
    }
}
