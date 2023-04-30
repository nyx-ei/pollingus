package com.nyxei.pollingus.models;

import com.nyxei.pollingus.models.question.Question;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private String language;
    @OneToMany
    private List<Question> questions;
}
