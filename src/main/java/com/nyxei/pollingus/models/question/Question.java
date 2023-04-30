package com.nyxei.pollingus.models.question;

import com.nyxei.pollingus.models.Poll;
import com.nyxei.pollingus.models.enums.AnswerType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
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
}
