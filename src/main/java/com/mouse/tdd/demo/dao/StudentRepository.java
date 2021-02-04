package com.mouse.tdd.demo.dao;

import com.mouse.tdd.demo.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
