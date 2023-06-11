package com.exclaimation.librarysystem.service;

import com.exclaimation.librarysystem.entity.Student;
import com.exclaimation.librarysystem.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public Long join(Student student) {
//        studentRepository.save(student);
//        return student.getStudentId();
//    }
}
