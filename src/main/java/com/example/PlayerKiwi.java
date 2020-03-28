package com.example;

import java.awt.*;

public class PlayerKiwi extends GameObject {

    private int moveCounter = 0;
    private int tmpEat;

    public PlayerKiwi(int x, int y, int directX, int directY, ID id, int eat, int age) {
        super(x, y, directX, directY, id, eat, age);
        setEat(randomEat());
    }

    @Override
    public void tick() {
        int newX;
        int newY;

        if (getId() != ID.PlayerKiwiToKill) {

            // losujemy counter jezeli jest 0
            if (moveCounter <= 0) {

                //wylicz ile ruchow zrobi obiekt
                moveCounter = randomMoveCounter();

                // wylicz losowy kierunek
                setDirectX(randomMove());
                setDirectY(randomMove());
            }

            // jesli counter > 0 wtedy wykonujemy ruch i zmniejszamy counter
            if (moveCounter > 0) {
                newX = getX() + getDirectX();
                newY = getY() + getDirectY();
                if (newX <= 5) {
                    setX(getX() + Math.abs(getDirectX()));
                } else {
                    setX(newX);
                }
                if (newY <= 5) {
                    setY(getY() + Math.abs(getDirectY()));
                } else {
                    setY(newY);
                }
                if (newX >= 630) {
                    setX(getX() - Math.abs(getDirectX()));
                }
                if (newY >= 630) {
                    setY(getY() - Math.abs(getDirectY()));
                }
                moveCounter--;
            }
            tmpEat = getEat();
            setEat(--tmpEat);
        }
        if (getId() == ID.PlayerKiwiYoung) {
            int tmpAge = getAge();
            setAge(++tmpAge);
            if (getAge() >= 500) {
                setId(ID.PlayerKiwi);
                System.out.println("Kiwi Grow up and can do multiplication");
            }
        } else {
            if (getEat() <= 1000) {
                setId(ID.PlayerKiwiToKill);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (getId() == ID.PlayerKiwiYoung) {
            g.setColor(Color.blue);
        } else if (getId() == ID.PlayerKiwiToKill) {
            g.setColor(Color.BLACK);
            tmpEat = getEat();
            setEat(--tmpEat);
            if (getEat() == 0) {
                setId(ID.PlayerKiwiKill);
            }
        } else {
            g.setColor(Color.white);
        }
        g.fillRect(getX(), getY(), 5, 5);
    }
}
