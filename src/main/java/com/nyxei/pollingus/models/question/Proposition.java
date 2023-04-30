package com.nyxei.pollingus.models.question;

import javax.persistence.*;

@Entity
public class Proposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String formulation;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
