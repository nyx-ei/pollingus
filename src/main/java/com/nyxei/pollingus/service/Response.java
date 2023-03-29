package com.nyxei.pollingus.service;

public class Response {

    public String userResponse;
    private static final long serialVersionUID = 1L;


    public Response(String r)
    {
        this.userResponse = r;
    }

    public String getUserResponse()
    {
        return this.userResponse;
    }

    // ajoute la réponse à la liste de réponses de Question
    public void addResponseToQuestion(IQuestion q)
    {
        q.response.add(this.userResponse);
    }
}
