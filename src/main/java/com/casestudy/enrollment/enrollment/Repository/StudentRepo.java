package com.casestudy.enrollment.enrollment.Repository;

import com.casestudy.enrollment.enrollment.Domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student,Integer> {

    List<Student> findBylNameContaining(String lName);
    List<Student> findByfNameContaining(String fName);
    void deleteByStudentId(int studentId);
    Student findByStudentId(int studentId);

}
