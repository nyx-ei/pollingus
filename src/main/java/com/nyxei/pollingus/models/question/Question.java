package com.nyxei.pollingus.models.question;

import com.nyxei.pollingus.models.Displayable;
import com.nyxei.pollingus.models.Poll;
import com.nyxei.pollingus.models.enums.AnswerType;
import com.nyxei.pollingus.utils.HtmlBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question implements Displayable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Integer number;
    private String formulation;
    private Boolean deleted = Boolean.FALSE;
    private Boolean random = Boolean.FALSE;
    @Enumerated(EnumType.ORDINAL)
    private AnswerType answerType;
    @OneToMany(mappedBy = "question")
    private List<Proposition> propositions = new ArrayList<>();
    @ManyToOne
    private Poll poll;
    @ManyToOne
    private Question affiliated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getRandom() {
        return random;
    }

    public void setRandom(Boolean random) {
        this.random = random;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Question getAffiliated() {
        return affiliated;
    }

    public void setAffiliated(Question affiliated) {
        this.affiliated = affiliated;
    }

    @Override
    public String toHtml() {
        return HtmlBuilder.format(this);
    }
}
