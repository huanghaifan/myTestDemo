package com.haifan.meihu.model.testmodel;

/**
 * Created by youxue on 2017/12/14.
 */

public class TestAnswer {

    private String QuestionsId;
    private String new_id;
    private String Answer;
    private String state;

    public String getQuestionsId() {
        return QuestionsId;
    }

    public void setQuestionsId(String questionsId) {
        QuestionsId = questionsId;
    }

    public String getNew_id() {
        return new_id;
    }

    public void setNew_id(String new_id) {
        this.new_id = new_id;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
