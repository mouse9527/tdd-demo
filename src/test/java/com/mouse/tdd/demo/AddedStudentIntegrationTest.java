package com.mouse.tdd.demo;

import com.mouse.tdd.demo.dao.ClassRepository;
import com.mouse.tdd.demo.dao.StudentRepository;
import com.mouse.tdd.demo.model.Class;
import com.mouse.tdd.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddedStudentIntegrationTest {
    @Resource
    private TestRestTemplate testRestTemplate;
    @Resource
    private ClassRepository classRepository;
    @Resource
    private StudentRepository studentRepository;

    @Test
    void should_be_able_to_add_student() {
        // step1: 准备数据 Given
        classRepository.save(new Class("101", "一年级一班"));
        Map<String, Object> body = new HashMap<>();
        body.put("classId", "101");
        body.put("name", "张三");
        body.put("gender", "male");
        body.put("studentId", "10101");

        // step2: 触发执行(http) When
        ResponseEntity<String> response = testRestTemplate.postForEntity("/students", body, String.class);

        // step3: 验证结果 Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        List<Student> students = studentRepository.findAll();
        assertThat(students).hasSize(1);
        Student student = students.get(0);
        assertThat(student.getId()).isNotEmpty();
        assertThat(student.getClassId()).isEqualTo("101");
        assertThat(student.getName()).isEqualTo("张三");
        assertThat(student.getGender()).isEqualTo("male");
        assertThat(student.getStudentId()).isEqualTo("10101");

        // clean(消除当前测试对系统的影响，防止对其他测试产生影响。这一步不一定有)
        studentRepository.delete(student.getId());
        classRepository.delete("101");
    }
}
