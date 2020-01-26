package com.example.motivationaldog;

public class Replies {
    private boolean embeddable, templated, _protected;
    private String href, taxonomy, name;
    private int id;

    public Replies(String href){
        this.href = href;
    }
    public Replies(boolean embeddable, String href){
        this.embeddable = embeddable;
        this.href = href;
    }

    public Replies(int id, String href){
        this.id = id;
        this.href = href;
    }
    public Replies(String taxonomy, boolean embeddable, String href){
        this.taxonomy = taxonomy;
        this.embeddable = embeddable;
        this.href = href;
    }
    public Replies(String name, String href, boolean templated){
        this.name = name;
        this.href = href;
        this.templated = templated;
    }
}
