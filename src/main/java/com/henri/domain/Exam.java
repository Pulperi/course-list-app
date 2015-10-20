package com.henri.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Exam extends AbstractPersistable<Long> implements Comparable<Exam>{
    
    private String organizer;
    
    @ManyToOne
    private Course course;
    
    private ExamType examType;
    
    @Column(name = "EXAM_DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public int compareTo(Exam other) {
        return this.date.compareTo(other.date);
    }
}
