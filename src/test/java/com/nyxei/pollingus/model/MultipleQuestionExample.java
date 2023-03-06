package com.nyxei.pollingus.model;

import com.nyxei.pollingus.model.MultipleQuestion;


import java.io.*;
import java.util.*;

public class MultipleQuestionExample {
    public static void main( String[] args ) throws Exception {
    
        String file = "testVS.json";
        
        try ( PrintWriter writer = new PrintWriter( file ) ) {
            
         String intitule= MultipleQuestion.intituleQuestion();
         ArrayList<String> proposition= (ArrayList<String>) MultipleQuestion.propositionQuestion();
         System.out.println(proposition.get(0));
         MultipleQuestion.writeObject( intitule, writer );
         MultipleQuestion.writeObject( proposition, writer );
        }
}
}
