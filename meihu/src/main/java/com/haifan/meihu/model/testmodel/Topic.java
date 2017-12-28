package com.haifan.meihu.model.testmodel;

/**
 * Created by youxue on 2017/12/14.
 */

public class Topic {

    private String Content;
    private boolean Contentis;
    private String Id;
    private String Title;
    private boolean Titleis;
    private String Answer;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isContentis() {
        return Contentis;
    }

    public void setContentis(boolean contentis) {
        Contentis = contentis;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isTitleis() {
        return Titleis;
    }

    public void setTitleis(boolean titleis) {
        Titleis = titleis;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
