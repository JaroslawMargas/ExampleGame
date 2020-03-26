package com.example;

import java.awt.*;

//klasa abstrakcyjna Obiekt
public abstract class GameObject {
    private int x;
    private int y;
    protected ID id;
    protected int velX, velY;

    //konstruktor
    public GameObject(int x, int y, ID id) {
        this.setX(x);
        this.setY(y);
        this.id = id;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }
}
