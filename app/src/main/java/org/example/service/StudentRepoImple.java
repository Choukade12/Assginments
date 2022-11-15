package org.example.service;

import org.example.exceptions.ResourceNotFoundException;
import org.example.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class StudentRepoImple {

    private StudentRepository studentRepository;

    public StudentRepoImple(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        UUID id  = UUID.randomUUID();
        student.setStudentId(id);
        studentRepository.save(student);
        return student;
    }

    public Student updateStudent(Student student){
     return studentRepository.save(student);
    }

    public Student findUsingId(UUID id){
        return studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User not found for id:"+ id)
        );
    }

    public void deleteStudent(UUID id){
            studentRepository.delete(findUsingId(id));
    }


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
