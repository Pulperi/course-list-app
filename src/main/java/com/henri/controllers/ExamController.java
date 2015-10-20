package com.henri.controllers;

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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exams")
public class ExamController {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private ExamRepository examRepository;
        
    @RequestMapping(method = RequestMethod.GET)
    public String getExams(Model model) {
        ArrayList<Exam> examList = new ArrayList<>(examRepository.findAll());
        Collections.sort(examList);
        
        Map<String, List<Exam>> exams = new HashMap<>();
        if (!examList.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY hh:mm");
            for (Exam e : examList) {
                String date = sdf.format(e.getDate());
                if (!exams.containsKey(date)) 
                    exams.put(date, new ArrayList<>());
                exams.get(date).add(e);
            }
        }
        
        model.addAttribute("exams", exams);        
        
        return "exams";
    }
    
    @PostConstruct
    public void init() {
        ArrayList<Course> courses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Course c = new Course();
            c.setCourseName("Course " + i);
            c.setCourseCode("ABC" + i);
            c.setCourseLevel(CourseLevel.Aineopinnot);
            c.setExams(new ArrayList<>());
            courses.add(c);
        }
        courseRepository.save(courses);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY hh:mm");
        ArrayList<Exam> exams = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Exam e = new Exam();
            Course c = courseRepository.findByCourseName("Course " + i%5);
            e.setCourse(c);
            try {
                e.setDate(sdf.parse("0" + i + ".01.2015 09:00"));
            } catch (ParseException ex) {
                Logger.getLogger(CourseListingAppApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.setExamType(ExamType.Kurssikoe);
            e.setOrganizer("Armi Assari # " + i);
            exams.add(e);
        }
        examRepository.save(exams);
    }
}
