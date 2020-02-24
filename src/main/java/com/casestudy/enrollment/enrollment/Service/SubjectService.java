package com.casestudy.enrollment.enrollment.Service;

import com.casestudy.enrollment.enrollment.Domain.Subject;
import com.casestudy.enrollment.enrollment.Repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    public String addSubject(Subject subject){
        subjectRepo.save(subject);
        return "New Subject added!";
    }

    public Subject updateSubject(Subject subject){
        return subjectRepo.save(subject);
    }

    public String deleteSubject(int subjectCode){
        subjectRepo.deleteBySubjectCode(subjectCode);
        return "Subject Deleted";
    }

    public List<Subject> getAllSubject(){
        List<Subject> subjects = new ArrayList<>();
        subjectRepo.findAll().forEach(subjects::add);
        return subjects;
    }

    public Subject getBySubjectCode(int subjectCode){
        return subjectRepo.findBySubjectCode(subjectCode);
    }

    public List<Subject> getBySubjectDesc(String subjectDesc){
        List<Subject> subjects = new ArrayList<>();
        subjectRepo.findBySubjectDescContaining(subjectDesc).forEach(subjects::add);
        return subjects;
    }

}
