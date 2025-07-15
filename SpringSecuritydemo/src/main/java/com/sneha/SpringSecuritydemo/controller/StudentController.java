package com.sneha.SpringSecuritydemo.controller;

import com.sneha.SpringSecuritydemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1 , "Sneha" , 89),
            new Student(2 , "Rahul" , 92)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    //getting the csrf token value
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
      return (CsrfToken)request.getAttribute("_csrf");
    }
    //Post , PUT, Delete mapping requires csrf token
    //the csrf token should be passed inside the Header
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
