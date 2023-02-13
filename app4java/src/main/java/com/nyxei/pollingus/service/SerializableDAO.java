package com.nyxei.pollingus.service;

import com.nyxei.pollingus.controller.Survey;

import java.io.*;
import java.util.ArrayList;

public class SerializableDAO {
    private static final String projectPath = "./";
    private static final String surveyExtension = ".ser";

    // affiche tous les fichiers qui ont été sérialisés, inclura les sondages et les réponses
    public ArrayList<String> getAllFiles()
    {

        File dir = new File(projectPath);

        ArrayList<String> serializedFiles = new ArrayList<>();
        File[] files = dir.listFiles();
        for (File f : files) {
            String fileName = f.getName();
            if (fileName.endsWith(".ser")) {
                serializedFiles.add(fileName.substring(0, fileName.lastIndexOf('.')));
            }
        }
        // renvoie les fichiers sérialisés sans leurs extensions, juste leurs noms
        return serializedFiles;
    }

    // désérialise le fichier demandé
    public Survey loadFile(String fileName)
    {
        Survey s = null;
        try{
            String filePath = fileName.concat(surveyExtension);

            FileInputStream input = new FileInputStream(filePath);
            ObjectInputStream output = new ObjectInputStream(input);
            s = (Survey) output.readObject();

            input.close();
            output.close();

            System.out.println("Object has been deserialized");
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.println("Could not deserialize file");
            System.out.println(e);
        }
        return s;
    }

    // sérialise l'objet demandé dans un fichier
    public void saveFile(Object obj, String fileName)
    {
        String filePath = fileName.concat(surveyExtension);

        try {
            FileOutputStream f = new FileOutputStream(filePath);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(obj);
            o.close();
            f.close();

            System.out.println("File has been successfully serialized");
        }
        catch(IOException e)
        {
            System.out.println("Path: " + filePath);
            System.out.println("Error: " + e);
            System.out.println("Could not serialize file");
        }
    }
}
