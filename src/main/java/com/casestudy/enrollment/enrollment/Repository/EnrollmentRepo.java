package com.casestudy.enrollment.enrollment.Repository;

import com.casestudy.enrollment.enrollment.Domain.Enrollment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnrollmentRepo extends CrudRepository<Enrollment,String> {

    public List<Enrollment> findByStudentId(int studentId);
    public List<Enrollment> findBySubjectCode(int subjectCode);
    void deleteBySubjectCodeAndStudentId(int subjectCode, int studentId);

}
