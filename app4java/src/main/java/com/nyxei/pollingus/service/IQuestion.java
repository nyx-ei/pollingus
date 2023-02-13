package com.nyxei.pollingus.service;

import com.nyxei.pollingus.controller.Survey;

import java.io.Serializable;
import java.util.ArrayList;

public class IQuestion implements Serializable {
    public String questionPrompt;
    public int questionNumber;

    public ArrayList<String> response;

    public ArrayList<String> responseList;

    // La question est créée avec une liste de réponses vide, qui sera remplie lorsque l'utilisateur répondra à l'enquête
    public IQuestion(String prompt, int qNumber)
    {
        this.questionPrompt = prompt;
        this.questionNumber = qNumber;
        this.response = new ArrayList<>();
    }

    public IQuestion(IQuestion q, ArrayList<String> c, int i) {
    }

    public Survey getSurvey(Survey s)
    {
        return null;
    }


    // renvoie uniquement l'invite de question
    public String getPrompt(com.nyxei.pollingus.service.IQuestion q)
    {
        return q.questionPrompt;
    }

    // affiche le numéro de la question et l'invite
    public void displayQuestion()
    {
        System.out.println("Q" + questionNumber + ": " + questionPrompt);
    }

    //affiche la ou les réponses à la question associée
    public void displayResponse()
    {
        System.out.println("Response: " + response);
        System.out.print("\n");
    }

    // obtient la réponse de l'utilisateur
    public void getUserResponse(IQuestion q)
    {
        System.out.print("Enter your response: ");
    }
}
