package com.nyxei.pollingus.model;

/*
 * dérive de la classe serializable
 * 
 */
import java.io.*;
import java.util.*;

public interface IQuestion extends Serializable {


  static void writeObject(Object object, PrintWriter writer )throws Exception{};

  
}