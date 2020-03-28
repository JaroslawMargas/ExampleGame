package com.example;

import java.awt.*;

public class PlayerSep extends GameObject {

    private int moveCounter = 0;

    public PlayerSep(int x, int y, int directX, int directY, ID id, int eat, int age) {
        super(x, y, directX, directY, id, eat, age);
    }

    @Override
    public void tick() {
        int newX;
        int newY;

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
            if (newX >= Game.WIDTH-10) {
                setX(getX() - Math.abs(getDirectX()));
            }
            if (newY >= Game.HEIGHT-10) {
                setY(getY() - Math.abs(getDirectY()));
            }
            moveCounter--;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getX(), getY(), 5, 5);
    }
}
