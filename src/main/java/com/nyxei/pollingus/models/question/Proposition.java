package com.nyxei.pollingus.models.question;

import com.nyxei.pollingus.models.Displayable;
import com.nyxei.pollingus.utils.HtmlBuilder;

import javax.persistence.*;

@Entity
public class Proposition implements Displayable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formulation;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toHtml() {
        return HtmlBuilder.format(this);
    }
}
