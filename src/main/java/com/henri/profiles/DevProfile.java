package com.henri.profiles;

import com.henri.CourseListingAppApplication;
import com.henri.domain.Course;
import com.henri.domain.CourseLevel;
import com.henri.domain.Exam;
import com.henri.domain.ExamType;
import com.henri.repository.CourseRepository;
import com.henri.repository.ExamRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = {"dev", "default"})
public class DevProfile {
//
//    @Autowired
//    private ExamRepository examRepo;
//    
//    @Autowired
//    private CourseRepository courseRepo;
//    
//    @PostConstruct
//    public void init() {
//                ArrayList<Course> courses = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Course c = new Course();
//            c.setCourseName("Course " + i);
//            c.setCourseCode("ABC" + i);
//            c.getCourseLevel(CourseLevel.Aineopinnot);
//        }
//        courseRepo.save(courses);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY hh:mm");
//        ArrayList<Exam> exams = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Exam e = new Exam();
//            Course c = courseRepo.findByCourseName("Course " + i%5);
//            e.setCourse(c);
//            c.getExams().add(e);
//            try {
//                e.setDate(sdf.parse("0." + i + ".01.2015 09:00"));
//            } catch (ParseException ex) {
//                Logger.getLogger(CourseListingAppApplication.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            e.setExamType(ExamType.Kurssikoe);
//            e.setOrganizer("Armi Assari # " + i);
//        }
//        examRepo.save(exams);
//        courseRepo.save(courses);
//    }
}
