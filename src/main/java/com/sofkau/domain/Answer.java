package com.sofkau.domain;

public class Answer {
    private Long id;
    private String answer;
    private Boolean correct;
    private Long questionId;

    public Answer(Long id, String answer, Boolean correct, Long questionId) {
        this.id = id;
        this.answer = answer;
        this.correct = correct;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", answer=" + answer + ", correct=" + correct + ", questionId="
                + questionId + "]";
    }
}
