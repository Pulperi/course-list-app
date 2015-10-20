package com.henri.domain;

public enum ExamType {
    Erilliskoe("Erilliskoe"), Kurssikoe("Kurssikoe"), Uusintakoe("Uusintakoe"), ;
    
    private final String type;
    
    private ExamType(String level) {
        this.type = level;
    }
    
    @Override
    public String toString() {
        return this.type;
    }
}
