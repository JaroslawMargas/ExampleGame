package com.example;

import com.example.GameObject;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends GameObject {

    Random random;
    private int directX = 0;
    private int directY = 0;
    private int counter = 0;

    public Player(int x, int y, ID id) {
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
            newX = x + directX;
            newY = y + directY;
            if (newX <= 5) {
                x = x + 1;
            }
            if (newY <= 5) {
                y = y + 1;
            }
            if (newX >= 630) {
                x = x - 1;
            } else {
                x = newX;
            }
            if (newY >= 630) {
                y = y - 1;
            } else {
                y = newY;
            }
            counter--;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 5, 5);

    }
}
