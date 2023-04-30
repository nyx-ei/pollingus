package com.nyxei.pollingus.utils;

import com.nyxei.pollingus.models.Poll;
import com.nyxei.pollingus.models.enums.AnswerType;
import com.nyxei.pollingus.models.question.Proposition;
import com.nyxei.pollingus.models.question.Question;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class HtmlBuilder {
    public static String format(Poll poll){
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>").append(poll.getName()).append("</h1>");
        builder.append("<h2>").append(poll.getTopic()).append("</h2>");
        IntStream.range(0, poll.getQuestions().size())
                .forEach(index -> {
                    poll.getQuestions().get(index).setNumber(index + 1);
                    builder.append(HtmlBuilder.format(poll.getQuestions().get(index)));
                });
        return builder.toString();
    }

    public static String format(Question question){
        StringBuilder builder = new StringBuilder("<h5>").append(StringUtils.defaultString(String.valueOf(question.getNumber()), "#"));
        builder.append(") ").append(question.getFormulation()).append("</h5>");
        switch (question.getAnswerType()){
            case DATE:
                builder.append("<input type='date' name='question").append(question.getId()).append("'>");
                break;
            case NUMBER:
                builder.append("<input type='number' name='question").append(question.getId()).append("'>");
                break;
            case EMAIL:
                builder.append("<input type='email' name='question").append(question.getId()).append("'>");
                break;
            case FILE:
                builder.append("<input type='file' name='question").append(question.getId()).append("'>");
                break;
            case SHORT_TEXT:
                builder.append("<input type='text' name='question").append(question.getId()).append("'>");
                break;
            case ONE_CHOICE:
            case MULTIPLE_CHOICE:
                question.getPropositions().forEach(proposition -> builder.append(HtmlBuilder.format(proposition)));
                break;
            case YES_NO:
                builder.append("<input type='radio' value='yes' name='question").append(question.getId()).append("' ").append("id='yes-question").append(question.getId()).append("'>");
                builder.append("<label for='yes-question").append(question.getId()).append("'>Oui</label><br>");
                builder.append("<input type='radio' value='no' name='question").append(question.getId()).append("' ").append("id='no-question").append(question.getId()).append("' checked>");
                builder.append("<label for='no-question").append(question.getId()).append("'>Non</label>");
                break;
            case PARAGRAPH:
                builder.append("<textarea minlength='100' rows='10' maxlength='65536' name='question").append(question.getId()).append("' required></textarea>");
                break;
            default:
                break;
        }
        return builder.toString();
    }

    public static String format(Proposition proposition){
        StringBuilder builder = new StringBuilder();
        builder.append("<input type='").append(AnswerType.MULTIPLE_CHOICE.equals(proposition.getQuestion().getAnswerType()) ? "checkbox" : "radio").append("' value='").append(proposition.getId()).append("' name='question").append(proposition.getQuestion().getId()).append("' ").append("id='proposition").append(proposition.getId()).append("'>");
        builder.append("<label for='proposition").append(proposition.getId()).append("'>").append(proposition.getFormulation()).append("</label><br>");
        return builder.toString();
    }
}
