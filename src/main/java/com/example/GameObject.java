package com.example;

import java.awt.*;

//klasa abstrakcyjna Obiekt
public abstract class GameObject {
    private int x;
    private int y;
    protected ID id;
    private int eat;

    //konstruktor
    public GameObject(int x, int y, ID id, int eat) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.eat = eat;
    }


    public abstract void tick();

    public abstract void render(Graphics g);
    

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public int getEat() {
        return eat;
    }

}
