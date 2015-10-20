package com.henri.domain;

import java.util.List;
import javax.persistence.Column;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Course extends AbstractPersistable<Long> {
    
    @Column(unique = true)
    private String courseName;
   
    @Column(unique = true)
    private String courseCode;
    
    private CourseLevel courseLevel;
    private boolean projectRequired = false;

    @OneToMany
    private List<Exam> exams;
    
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }

    public boolean isProjectRequired() {
        return projectRequired;
    }

    public void setProjectRequired(boolean projectRequired) {
        this.projectRequired = projectRequired;
    }
    
    
}
