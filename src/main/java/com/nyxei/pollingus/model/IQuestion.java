package com.nyxei.pollingus.model;

/*
 * dérive de la classe serializable
 * 
 */
import java.io.*;


public interface IQuestion extends Serializable {


  static void writeObject(Object object, PrintWriter writer )throws Exception{};

  
}