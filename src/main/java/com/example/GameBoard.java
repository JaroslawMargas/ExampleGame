package com.example;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class GameBoard {

    private int x;
    private int y;
    private int width;
    private int height;
    private ID id;
    BufferedImage img;


    public GameBoard(int x, int y, ID id, BufferedImage img, int width, int height) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.img = img;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();
    public abstract void render(Graphics g) throws IOException;

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setId(ID id) {
        this.id = id;
    }

    public void setWidth(int x) {
        this.x = x;
    }
    public void setHeight(int y) {
        this.y = y;
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

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }


}
