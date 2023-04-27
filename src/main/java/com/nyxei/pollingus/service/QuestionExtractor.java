package com.nyxei.pollingus.service;

import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Heading;
import org.commonmark.node.Paragraph;

import javax.swing.text.ParagraphView;
import java.util.ArrayList;
import java.util.List;

public class QuestionExtractor {
    static class QuestionVisitor extends AbstractVisitor {
        private List<String> questions;

        public QuestionVisitor(){
            //initialser la liste
            questions = new ArrayList<>();
        }
        public List<String> getQuestions(){
            //rettourner la liste
            return questions;
        }

        @Override
        public void visit(Heading heading){
            //Si le noeud est un titre, ajouter son texte à la liste
            questions.add(heading.getFirstChild().toString());
        }

        @Override
        public void visit(Paragraph paragraph){
            //si le noeud est un paragraphe vérifier qu'il commence par un numéro
            String text = paragraph.getFirstChild().toString();
            String s = text;
            if (text.matches(s)){
                questions.add(text);
            }
        }
    }
}
