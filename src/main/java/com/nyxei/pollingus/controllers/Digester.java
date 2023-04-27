package com.nyxei.pollingus.controllers;

import com.nyxei.pollingus.service.Survey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Digester {
    public Survey survey;

    public static void  lectureMd(String fileReader){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileReader));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
