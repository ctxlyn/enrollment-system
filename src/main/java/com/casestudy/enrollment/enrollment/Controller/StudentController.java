package com.casestudy.enrollment.enrollment.Controller;

import com.casestudy.enrollment.enrollment.Domain.Student;
import com.casestudy.enrollment.enrollment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @Transactional
    @DeleteMapping(value = "/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
       return studentService.deleteStudent(studentId);
    }

    @GetMapping(value = "/getByStudentId/{studentId}")
    public Student getByStudentId(@PathVariable int studentId){
        return studentService.getByStudentId(studentId);
    }

    @GetMapping(value = "/getAllStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/getByFName/{fName}")
    public List<Student> getByFName(@PathVariable String fName){
        return studentService.getByFName(fName);
    }

    @GetMapping(value = "/getByLName/{lName}")
    public List<Student> getByLName(@PathVariable String lName){
        return studentService.getByLName(lName);
    }


}
