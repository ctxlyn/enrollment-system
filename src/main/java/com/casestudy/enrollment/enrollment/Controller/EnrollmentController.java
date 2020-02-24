package com.casestudy.enrollment.enrollment.Controller;

import com.casestudy.enrollment.enrollment.Domain.Enrollment;
import com.casestudy.enrollment.enrollment.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping(value = "/getEnrollmentByStudentId/{studentId}")
    public List<Enrollment> getEnrollmentByStudentId(@PathVariable int studentId){
        return enrollmentService.getByStudentId(studentId);
    }

    @GetMapping(value = "/getAllEnrollments")
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollment();
    }

    @GetMapping(value = "/getEnrollmentBySubjectCode/{subjectCode}")
    public List<Enrollment> getEnrollmentBySubjectCode(@PathVariable int subjectCode){
        return enrollmentService.getBySubjectCode(subjectCode);
    }

    @Transactional
    @DeleteMapping(value = "/deleteEnrollment/{subjectCode}/{studentId}")
    public void deleteEnrollment(@PathVariable int subjectCode, @PathVariable int studentId){
        enrollmentService.deleteEnrollment(subjectCode, studentId);
    }

    @PostMapping(value = "/enroll")
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment){
        return enrollmentService.addEnrollment(enrollment);
    }

}
