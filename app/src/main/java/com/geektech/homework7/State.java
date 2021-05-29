package com.geektech.homework7;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class State {

    private String name;
    private String capital;
    private Drawable flagResource;
    private int color;

    public State(String name, String capital, Drawable flagResource, int color) {
        this.name = name;
        this.capital = capital;
        this.flagResource = flagResource;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Drawable getFlagResource() {
        return flagResource;
    }

    public void setFlagResource(Drawable flagResource) {
        this.flagResource = flagResource;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
