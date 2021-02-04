package com.mouse.tdd.demo.model;

import com.mouse.tdd.demo.vo.AddStudentRequest;

public class Student {
    private final String id;
    private final String studentId;
    private final String name;
    private final String classId;
    private final String gender;

    public Student(String id, AddStudentRequest request) {
        this.id = id;
        this.studentId = request.getStudentId();
        this.name = request.getName();
        this.classId = request.getClassId();
        this.gender = request.getGender();
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getClassId() {
        return classId;
    }

    public String getGender() {
        return gender;
    }
}
