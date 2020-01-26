package com.example.motivationaldog;

public class LevelTwoObjects {

    private String rendered;
    private boolean _protected;

    public LevelTwoObjects(String rendered, boolean _protected) {
        this.rendered = rendered;
        this._protected = _protected;
    }

    public LevelTwoObjects(String rendered){
        this.rendered = rendered;
    }

    public String getQuote(){
        return rendered;
    }

}
