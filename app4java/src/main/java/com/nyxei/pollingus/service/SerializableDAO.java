package com.nyxei.pollingus.service;

import com.nyxei.pollingus.controller.Survey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;

public class SerializableDAO {
    private static final String projectPath = "./";
    private static final String surveyExtension = ".ser";

    public static Logger logger = LoggerFactory.getLogger(Survey.class);
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
            logger.debug("Object has been deserialized");
        }
        catch(IOException | ClassNotFoundException e)
        {
            logger.debug("Could not deserialize file");
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

            logger.debug("File has been successfully serialized");
        }
        catch(IOException e)
        {
            logger.debug("Path: " + filePath);
            logger.debug("Error: " + e);
            logger.debug("Could not serialize file");
        }
    }
}
