package com.example.motivationaldog;

public class QuotesOnDesignResults {
    int ID;
    String title;
    String content;
    String link;

    public QuotesOnDesignResults(int ID, String title, String content, String link) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.link = link;
    }

    public QuotesOnDesignResults() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return content;
    }
}
