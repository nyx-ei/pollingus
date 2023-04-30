package com.nyxei.pollingus.models.form;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private List<Field> fields = new ArrayList<>();
}
