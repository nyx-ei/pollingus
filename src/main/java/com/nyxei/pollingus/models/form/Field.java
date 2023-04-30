package com.nyxei.pollingus.models.form;

import com.nyxei.pollingus.models.enums.FieldType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String label;
    private String description;
    private boolean required = false;
    @Enumerated(EnumType.ORDINAL)
    private FieldType fieldType;
    @ManyToMany
    private List<Form> forms;
}
