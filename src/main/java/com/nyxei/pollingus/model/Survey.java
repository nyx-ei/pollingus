package com.nyxei.pollingus.model;

import java.util.*;

import com.nyxei.pollingus.model.MultipleQuestion;

public class Survey {

   private MultipleQuestion questionList ;
   private String titreSondage;
   private String idSondeur;
   private ArrayList<String> destinataireList=new ArrayList<String>();
/* 
    public Survey(OneChoiceQuestion qList,String titreS, String idSondeur,ArrayList<String> dList){
        this.questionList=qList;
        this.titreSondage=titreS;
        this.idSondeur=idSondeur;
        this.destinataireList=dList;
    }
    */
    public Survey(MultipleQuestion qList){
        this.questionList=qList;
        this.titreSondage="Pollingus";
        this.idSondeur="NYX-EI";
        this.destinataireList.add("237697887157");
    }
    public MultipleQuestion getQuestionList(){

        return this.questionList;
    }
    public ArrayList<String> getDestinataireList(){

        return this.destinataireList;
    }
    public String getTitreSondage(){

        return this.titreSondage;
    }
    public String getIdSondeur(){

        return this.idSondeur;
    }




}
