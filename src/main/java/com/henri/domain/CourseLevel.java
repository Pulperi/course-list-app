package com.henri.domain;

public enum CourseLevel {
    Aineopinnot("Aineopinnot"), Syventavat("Syventävät opinnot");
    
    private final String level;
    
    private CourseLevel(String level) {
        this.level = level;
    }
    
    @Override
    public String toString() {
        return this.level;
    }
}
