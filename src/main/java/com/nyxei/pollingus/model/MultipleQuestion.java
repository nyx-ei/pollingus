package com.nyxei.pollingus.model;

/*
 * dérive de la classe serializable
 * 
 */
import java.io.*;
import java.util.*;


public class MultipleQuestion implements IQuestion {

  private  String intituleQ;
  private  ArrayList<String> propositionQ;
  




  public MultipleQuestion(String s,ArrayList<String> prQ ){
    this.intituleQ=s;
    this.propositionQ=prQ;
  }
  public ArrayList<String> getPropositionList(){

    return this.propositionQ;
}
public String getIntitule(){

  return this.intituleQ;
}
  

  /**
   * @return
   */
  
  static ArrayList<String>fichierLecture(){
     
    ArrayList<String> tabString=new ArrayList<String>();
        String line="";
      
    try {
    
      FileReader file = new FileReader("src/test/java/com/nyxei/pollingus/model/multipleChoiceQ.md");
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
   String intitule="";
    ArrayList<String> tabString=fichierLecture();
    for(int i=0;i<tabString.size();i++){
        if(tabString.get(i).indexOf("###")==0){
         intitule=tabString.get(i);
        }
   }
     return intitule; 
  }

  public static List<String> propositionQuestion(){
    List<String> proposition=new ArrayList<String>();
    ArrayList<String> tabString=fichierLecture();
    for(int i=0;i<tabString.size();i++){
        if(tabString.get(i).indexOf("###")!=0){
           proposition.add(tabString.get(i).split(" ]")[1]);
        }
   }
     return proposition; 
  }

  public static void writeObject(Object object, PrintWriter writer )throws Exception {
    Class<?> metadata = object.getClass();
    if ( metadata == Byte.class ||
         metadata == Short.class ||
         metadata == Integer.class ||
         metadata == Long.class ||
         metadata == Float.class ||
         metadata == Double.class ||
         metadata == Boolean.class ) {
        // --- On gère les types de bases ---
        writer.println( "" + object );
    } else if ( metadata == String.class || metadata == Character.class ) {
        // --- On gère les chaînes de caractères ---
        writer.println( "\" " + object + " \""+"," );
    } 
    else if ( metadata.isArray() || object instanceof List ) {
        // --- On gère les tableaux et les collections ---
        @SuppressWarnings("rawtypes") 
        List collection = (List) object  ;
        int size = collection.size();
        int i = 0;

        writer.println( "[" );
        for( Object value : collection ) {
         
            writeObject( value, writer );
            if ( i++ < size - 1 ){} //writer.print( "," );
        }
        writer.println( "]" );
    }
    else {
        // --- On gère les objets Java ---
        throw new Exception( "Not actually implemented" );
    }
}
 /* 
 public static void main( String[] args ) throws Exception {
    
  String file = "testVS.json";
  
  try ( PrintWriter writer = new PrintWriter( file ) ) {
      
   String intitule= MultipleQuestion.intituleQuestion();
   ArrayList<String> proposition= (ArrayList<String>) MultipleQuestion.propositionQuestion();
   System.out.println(proposition.get(0));
   writeObject( intitule, writer );
   writeObject( proposition, writer );
  }
  

}
 */ 










}