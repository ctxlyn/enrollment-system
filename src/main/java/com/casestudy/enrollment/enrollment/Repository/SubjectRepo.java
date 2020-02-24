package com.casestudy.enrollment.enrollment.Repository;

import com.casestudy.enrollment.enrollment.Domain.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepo extends CrudRepository<Subject, Integer> {

    List<Subject> findBySubjectDescContaining(String subjectDesc);
    void deleteBySubjectCode(int subjectCode);
    Subject findBySubjectCode(int subjectCode);



}
