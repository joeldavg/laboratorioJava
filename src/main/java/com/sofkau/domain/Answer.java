package com.sofkau.domain;

public class Answer {
    private Long id;
    private String question;
    private Long categoryId;

    public Answer(Long id, String question, Long categoryId) {
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

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoryId = categoriaId;
    }
    @Override
    public String toString() {
        return "Question [id=" + id + ", question=" + question + ", categoryId=" + categoryId + "]";
    }
}
