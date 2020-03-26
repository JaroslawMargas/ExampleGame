package com.example;

import java.awt.*;
import java.util.Random;

public class PlayerKiwi extends GameObject {

    Random random;
    private int directX = 0;
    private int directY = 0;
    private int counter = 0;

    public PlayerKiwi(int x, int y, ID id) {
        super(x, y, id);

    }

    // wylosuj ile krokow zrobi obiekt
    private int randomMoveCounter() {
        random = new Random();
        return random.nextInt(25);
    }

    // wylosuj kierunek(-1,1)
    private int randomMove() {
        random = new Random();
        int result = random.nextInt(3);
        if (result == 2)
            return (-1);
        return result;
    }

    @Override
    public void tick() {
        int newX;
        int newY;

        // losujemy counter jezeli jest 0
        if (counter <= 0) {

            //wylicz ile ruchow zrobi obiekt
            counter = randomMoveCounter();

            // wylicz losowy kierunek
            directX = randomMove();
            directY = randomMove();
        }

        // jesli counter > 0 wtedy wykonujemy ruch i zmniejszamy counter
        if (counter > 0) {
            newX = getX() + directX;
            newY = getY() + directY;
            if (newX <= 5) {
                setX(getX() + 1);
            }else {
                setX(newX);
            }
            if (newY <= 5) {
                setY(getY() + 1);
            }
            else {
                setY(newY);
            }
            if (newX >= 630) {
                setX(getX() - 1);
            }
            if (newY >= 630) {
                setY(getY() - 1);
            }
            counter--;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(getX(), getY(), 5, 5);

    }
}
