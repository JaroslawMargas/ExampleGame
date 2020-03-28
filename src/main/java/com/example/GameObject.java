package com.example;

import java.awt.*;
import java.util.Random;

public abstract class GameObject {
    private int x;
    private int y;
    private int directX;
    private int directY;
    protected ID id;
    private int eat;
    private int age;

    public GameObject(int x, int y,int directX,int directY, ID id, int eat, int age) {
        this.x = x;
        this.y = y;
        this.directX = directX;
        this.directY = directY;
        this.id = id;
        this.eat = eat;
        this.age = age;
    }

    public abstract void tick();
    public abstract void render(Graphics g);


    public static int randomEat(){
        Random random  = new Random();
        int eatMin = 5000;
        int eatMax = 10_000;
        return random.nextInt((eatMax - eatMin) + 1) + eatMin;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirectX(int directX) {
        this.directX = directX;
    }

    public void setDirectY(int directY) {
        this.directY = directY;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirectX() {
        return directX;
    }

    public int getDirectY() {
        return directY;
    }

    public ID getId() {
        return id;
    }

    public int getEat() {
        return eat;
    }

    public int getAge() {
        return age;
    }

    // wylosuj ile krokow zrobi obiekt
    public int randomMoveCounter() {
        Random random = new Random();
        return random.nextInt(50);
    }

    // wylosuj kierunek(-1,1)
    public static int randomMove() {
        Random random;
        random = new Random();
        int result = random.nextInt(3);
        if (result == 2)
            return (-1);
        return result;
    }
}
