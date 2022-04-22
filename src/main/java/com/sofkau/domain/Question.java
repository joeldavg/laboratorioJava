package com.sofkau.domain;

public class Question {
    private Long id;
    private String question;
    private Long categoryId;

    public Question(Long id, String question, Long categoryId) {
        this.id = id;
        this.question = question;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setPregunta(String question) {
        this.question = question;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "question [id=" + id + ", question=" + question + ", categoryId=" + categoryId + "]";
    }
}
