package com.nyxei.pollingus.service;

import java.util.ArrayList;

public class QuestionYesNo extends IQuestion {

    public ArrayList<String> choices;

    // Uses MultipleChoice's constructor, will have its own set of choices and only accepts 1 response
    public QuestionYesNo(IQuestion q, ArrayList<String> c)
    {
        super(q, c, 1);
        this.choices = c;
    }

    // True/False will only have 2 options, display them and the question
    public void displayQuestion()
    {
        System.out.println("Q" + questionNumber + ": " + questionPrompt);
        System.out.println("a. " + choices.get(0));
        System.out.println("b. " + choices.get(1));
        System.out.print("\n");
    }
    public QuestionYesNo(String prompt, int qNumber) {
        super(prompt, qNumber);
    }
}
