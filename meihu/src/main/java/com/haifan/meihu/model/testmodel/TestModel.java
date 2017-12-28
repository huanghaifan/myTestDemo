package com.haifan.meihu.model.testmodel;

import java.util.List;

/**
 * Created by youxue on 2017/12/14.
 */

public class TestModel {
    private Option option;
    private Topic topic;
    private Question question;
    private List<Note> noteList;
    private TestAnswer testAnswer;

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public TestAnswer getTestAnswer() {
        return testAnswer;
    }

    public void setTestAnswer(TestAnswer testAnswer) {
        this.testAnswer = testAnswer;
    }
}
