package com.mouse.tdd.demo.service;

import com.mouse.tdd.demo.dao.ClassRepository;
import com.mouse.tdd.demo.dao.StudentRepository;
import com.mouse.tdd.demo.vo.AddStudentRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class StudentServiceTest {

    @Test
    void should_be_able_to_reject_add_when_class_id_not_found() {
        // Given
        ClassRepository classRepository = mock(ClassRepository.class);
        given(classRepository.exists("unknown-classId")).willReturn(false);
        StudentRepository studentRepository = mock(StudentRepository.class);
        StudentService studentService = new StudentService(studentRepository, classRepository);
        AddStudentRequest request = new AddStudentRequest();
        request.setClassId("unknown-classId");

        // When
        Throwable throwable = catchThrowable(() -> studentService.add(request));

        // Then
        assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("Unknown classId");
        then(studentRepository).shouldHaveNoInteractions();
    }
}
