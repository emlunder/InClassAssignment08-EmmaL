package com.example.cmltdstudent.inclassassignment08_emmal2;

import java.io.Serializable;

public class MathScore implements Serializable
{
    private String user;
    private int score;
    private boolean pass;

    public MathScore(){}

    public MathScore(String user, int score, boolean pass)
    {
        this.user = user;
        this.score = score;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return user + " " + score + " " + pass + "\n";
    }
}

