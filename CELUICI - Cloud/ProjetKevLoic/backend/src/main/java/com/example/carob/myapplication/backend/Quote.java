package com.example.carob.myapplication.backend;

/**
 * Created by carob on 5/9/2017.
 */

public class Quote {
    Long id;
    String who;
    String whom;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getWho() {
        return who;
    }
    public void setWho(String who) {
        this.who = who;
    }
    public String getWhom() {
        return whom;
    }
    public void setWhom(String whom) {
        this.whom = whom;
    }
}
