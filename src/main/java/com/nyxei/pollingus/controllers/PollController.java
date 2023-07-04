package com.nyxei.pollingus.controllers;

import com.nyxei.pollingus.models.Poll;
import com.nyxei.pollingus.models.enums.AnswerType;
import com.nyxei.pollingus.models.question.Proposition;
import com.nyxei.pollingus.models.question.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/polls")
public class PollController {
    //private final Po
    @GetMapping("{id}")
    public String display(@PathVariable long id, Model model){
        Poll poll = new Poll();
        poll.setName("Poll name");
        poll.setTopic("Poll topic");
        Question question1 = new Question();
        question1.setId(1L);
        question1.setFormulation("Quelle est ta date de naissance ?");
        question1.setAnswerType(AnswerType.DATE);
        question1.setPoll(poll);
        poll.getQuestions().add(question1);
        Question question2 = new Question();
        question2.setId(2L);
        question2.setFormulation("Faites une brève description de votre expérience professionnelle");
        question2.setAnswerType(AnswerType.PARAGRAPH);
        question2.setPoll(poll);
        poll.getQuestions().add(question2);
        Question question3 = new Question();
        question3.setId(3L);
        question3.setFormulation("Etes vous marié ? ");
        question3.setAnswerType(AnswerType.YES_NO);
        question3.setPoll(poll);
        poll.getQuestions().add(question3);
        Question question4 = new Question();
        question4.setId(4L);
        question4.setFormulation("Quelle est l'année d'indépendance du Cameroun ? ");
        question4.setAnswerType(AnswerType.ONE_CHOICE);
        question4.setPoll(poll);
        Proposition p1 = new Proposition();
        p1.setFormulation("1780");
        p1.setQuestion(question4);
        Proposition p2 = new Proposition();
        p2.setFormulation("1960");
        p2.setQuestion(question4);
        Proposition p3 = new Proposition();
        p3.setFormulation("1840");
        p3.setQuestion(question4);
        Proposition p4 = new Proposition();
        p4.setFormulation("1945");
        p4.setQuestion(question4);
        question4.setPropositions(Arrays.asList(p1, p2, p3, p4));
        poll.getQuestions().add(question4);
        model.addAttribute("poll", poll);
        return "poll";
    }
}
