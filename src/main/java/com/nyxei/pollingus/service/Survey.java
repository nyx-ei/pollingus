package com.nyxei.pollingus.service;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    public List<String> listeDesQuestions;
    public String titreSondage;
    public String identiteSondeur;

    public Survey(List<String> listeDesQuestions, String titreSondage, String identiteSondeur) {
        this.listeDesQuestions = listeDesQuestions;
        this.titreSondage = titreSondage;
        this.identiteSondeur = identiteSondeur;
    }
}
