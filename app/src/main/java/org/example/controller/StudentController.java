package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentRepoImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/StudentCRUD")

public class StudentController {

    private StudentRepoImple studentRepoImple;

    public StudentController(StudentRepoImple studentRepoImple) {
        this.studentRepoImple = studentRepoImple;
    }
    //jsonignore

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Student> create(@RequestBody Student student){
        student = studentRepoImple.createStudent(student);
        return ResponseEntity.status(202).body(student);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Student> update(@RequestBody Student student){
       student = studentRepoImple.updateStudent(student);
       return ResponseEntity.status(202).body(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") UUID id){
     Student student = studentRepoImple.findUsingId(id);
     return ResponseEntity.status(202).body(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentRepoImple.getAllStudent();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id){
        studentRepoImple.deleteStudent(id);
    }
}
