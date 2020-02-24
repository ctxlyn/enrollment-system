package com.casestudy.enrollment.enrollment.Service;

import com.casestudy.enrollment.enrollment.Domain.Enrollment;
import com.casestudy.enrollment.enrollment.Domain.Student;
import com.casestudy.enrollment.enrollment.Domain.Subject;
import com.casestudy.enrollment.enrollment.Repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    public List<Enrollment> getAllEnrollment(){
        List<Enrollment> enrollments = new ArrayList<>();
        enrollmentRepo.findAll().forEach(enrollments::add);
        return enrollments;
    }

    public List<Enrollment> getByStudentId(int studentId){
        List<Enrollment> students = new ArrayList<>();
        enrollmentRepo.findByStudentId(studentId).forEach(students::add);
        return students;
    }

    public List<Enrollment> getBySubjectCode(int subjectCode){
        List<Enrollment> subjects = new ArrayList<>();
        enrollmentRepo.findBySubjectCode(subjectCode).forEach(subjects::add);
        return subjects;
    }

    public Enrollment addEnrollment(Enrollment enrollment){
        RestTemplate studentRT = new RestTemplate();
        Student student = studentRT.getForObject("http://localhost:8080/getByStudentId/"
                                                + enrollment.getStudentId(), Student.class);

        RestTemplate subjectRT = new RestTemplate();
        Subject subject = subjectRT.getForObject("http://localhost:8080/getBySubjectCode/"
                                                + enrollment.getSubjectCode(), Subject.class);

        Enrollment e = new Enrollment();
        e.setEnrollmentId(enrollment.getEnrollmentId());
        e.setStudentId(student.getStudentId());
        e.setSubjectCode(subject.getSubjectCode());
        return enrollmentRepo.save(e);
    }

    public void deleteEnrollment(int subjectCode, int studentId){
        enrollmentRepo.deleteBySubjectCodeAndStudentId(subjectCode, studentId);
    }

}
