package com.nyxei.pollingus.model;

import java.io.*;
import java.util.*;

import com.nyxei.pollingus.model.MultipleQuestion;
import com.nyxei.pollingus.model.Survey;

public class Digester {

   // public static  Survey survey;
    static String intituleQ;
    static List<String> propositionQ=new ArrayList<String>();

    
  

    static ArrayList<String>fichierLecture(){
     
        ArrayList<String> tabString=new ArrayList<String>();
            String line="";
          
        try {
        
          FileReader file = new FileReader("testVS.json");
          try (BufferedReader buffer = new BufferedReader(file)) {
            while((line = buffer.readLine()) != null)
        {
            tabString.add(line);   
        }
          }
        } catch (IOException ex) {
         ex.printStackTrace();
       }
         return tabString; 
      }

      static String intituleQuestion(){
       
         ArrayList<String> tabString=fichierLecture();
        
            
              intituleQ=tabString.get(0).split("### ")[1].split(" \",")[0];
             
        
          return intituleQ; 
       }
     
       public static ArrayList<String> propositionQuestion(){
         ArrayList<String> proposition=new ArrayList<String>();
         ArrayList<String> tabString=fichierLecture();
         for(int i=1;i<tabString.size();i++){
            
             proposition.add(tabString.get(i).substring(1).split("\",")[0]);
        }
          return proposition; 
       }
       public static MultipleQuestion ObjectSurvey(){
              MultipleQuestion question= new MultipleQuestion(intituleQuestion(), propositionQuestion());
                return  question;
       }
       public final static  Survey survey= new Survey(ObjectSurvey());
       
public static void main(String [] args){

  Survey surveys= new Survey(ObjectSurvey());
 System.out.println(surveys.getDestinataireList().get(0));

}






}



