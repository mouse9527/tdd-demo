package com.mouse.tdd.demo.dao;

import com.mouse.tdd.demo.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RAMStudentRepository implements StudentRepository {
    private final List<Student> db;

    public RAMStudentRepository() {
        this.db = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public List<Student> findAll() {
        return db;
    }

    @Override
    public void delete(String id) {
        db.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public void save(Student student) {
        db.add(student);
    }
}
