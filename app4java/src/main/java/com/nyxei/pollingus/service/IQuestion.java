package com.nyxei.pollingus.service;

import com.nyxei.pollingus.controller.Survey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class IQuestion implements Serializable {
    public String questionPrompt;
    public int questionNumber;

    public ArrayList<String> response;

    public ArrayList<String> responseList;

    public static Logger logger = LoggerFactory.getLogger(Survey.class);

    //  affiche le numéro de la question et l'invite
    @Override
    public String toString() {
        return "IQuestion{" +
                "Q" + questionNumber +
                ": " + questionPrompt + '\'' +
                '}';
    }

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
    public String getPrompt(IQuestion q)
    {
        return q.questionPrompt;
    }



    //affiche la ou les réponses à la question associée
    public void displayResponse()
    {
        logger.debug("Response: " + response);
    }


    // obtient la réponse de l'utilisateur
    public void getUserResponse(IQuestion q)
    {
        logger.debug("Enter your response: ");
        Response r = new Response(response.toString());
        r.addResponseToQuestion(q);
    }
}
