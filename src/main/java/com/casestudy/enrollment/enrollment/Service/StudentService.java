package com.casestudy.enrollment.enrollment.Service;

import com.casestudy.enrollment.enrollment.Domain.Student;
import com.casestudy.enrollment.enrollment.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public String addStudent(Student student){
        studentRepo.save(student);
        return "New Student Added";
    }

    public String deleteStudent(int studentId){
        studentRepo.deleteByStudentId(studentId);
        return "Student deleted";
    }

    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        studentRepo.findAll().forEach(students::add);
        return students;
    }


    public Student getByStudentId(int studentId){
        return studentRepo.findByStudentId(studentId);
    }

    public List<Student> getByFName(String fName){
        List<Student> student = new ArrayList<>();
        studentRepo.findByfNameContaining(fName).forEach(student::add);
        return student;
    }

    public List<Student> getByLName(String lName){
        List<Student> students = new ArrayList<>();
        studentRepo.findBylNameContaining(lName).forEach(students::add);
        return students;
    }

}
