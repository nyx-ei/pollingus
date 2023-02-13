package com.nyxei.pollingus.controller;

import com.nyxei.pollingus.service.IQuestion;
import com.nyxei.pollingus.service.SerializableDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Survey implements Serializable {
    public Scanner reader;
    public ArrayList<IQuestion> questions;
    public String surveyName;
    private static final long serialVersionUID = 1L;

    // create a dao for serialization
    private static final SerializableDAO dao = new SerializableDAO();

    // L'enquête est instanciée avec un nom et une liste d'objets Question
    public Survey(ArrayList<IQuestion> listOfQuestions, String name)
    {
        this.questions = listOfQuestions;
        this.surveyName = name;
    }

    // affiche chaque question et sa réponse si l'enquête chargée a été prise
    public void display()
    {
        for (IQuestion x: this.questions)
        {
            x.displayQuestion();
            if(x.response.size() > 0) {
                x.displayResponse();
            }
        }
    }

    // ajoute une question au sondage
    public void addQuestion(IQuestion q)
    {
        this.questions.add(q);
    }

    // obtient une question en utilisant son numéro, utilise la fonction d'édition de Question
    public void editSurvey(int qNumber)
    {
        for (IQuestion x: questions)
        {
            if(x.questionNumber == qNumber)
            {
                x.displayQuestion();
            }
        }
    }


    // utilise l'objet dao pour enregistrer l'enquête à laquelle il est passé
    public static void serialize(Survey s)
    {
        Survey duplicate = s;
        dao.saveFile(duplicate, s.surveyName);
        s.display();
        System.out.println("Saved");
    }

    // utilise l'objet dao pour charger l'enquête à partir du chemin parcouru, renvoie l'enquête chargée
    public static Survey deserialize(String path)
    {
        Survey loaded = dao.loadFile(path);
        return loaded;
    }
}
