package com.casestudy.enrollment.enrollment.Controller;

import com.casestudy.enrollment.enrollment.Domain.Subject;
import com.casestudy.enrollment.enrollment.Repository.SubjectRepo;
import com.casestudy.enrollment.enrollment.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "/addSubject")
    public String addSubject(@Valid @RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

    @PutMapping(value = "/updateSubject")
    public Subject updateSubject(@RequestBody Subject subject){
        return subjectService.updateSubject(subject);
    }

    @Transactional
    @DeleteMapping(value = "/deleteSubject/{subjectCode}")
    public String deleteSubject(@PathVariable int subjectCode){
      return subjectService.deleteSubject(subjectCode);
    }

    @GetMapping(value = "/getAllSubject")
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @GetMapping(value = "/getBySubjectCode/{subjectCode}")
    public Subject getBySubjectCode(@PathVariable int subjectCode){
        return subjectService.getBySubjectCode(subjectCode);
    }

    @GetMapping(value = "/getBySubjectDesc/{subjectDesc}")
    public List<Subject> getBySubjectDesc(@PathVariable String subjectDesc){
        return subjectService.getBySubjectDesc(subjectDesc);
    }

}
