package com.example;

import java.awt.*;
import java.util.Random;

public class PlayerKiwi extends GameObject {

    Random random;
    private int directX = 0;
    private int directY = 0;
    private int moveCounter = 0;
    private int grow = 0;
    private int eat;


    public PlayerKiwi(int x, int y, ID id, int eat) {
        super(x, y, id, eat);
        setEat(randomEat());

    }

    private int randomEat(){
        random  = new Random();
        int eatMin = 10_000;
        int eatMax = 100_000;
        return random.nextInt((eatMax - eatMin) + 1) + eatMin;
    }
    // wylosuj ile krokow zrobi obiekt
    private int randomMoveCounter() {
        random = new Random();
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
                directX = randomMove();
                directY = randomMove();
            }

            // jesli counter > 0 wtedy wykonujemy ruch i zmniejszamy counter
            if (moveCounter > 0) {
                newX = getX() + directX;
                newY = getY() + directY;
                if (newX <= 5) {
                    setX(getX() + Math.abs(directX));
                } else {
                    setX(newX);
                }
                if (newY <= 5) {
                    setY(getY() + Math.abs(directY));
                } else {
                    setY(newY);
                }
                if (newX >= 630) {
                    setX(getX() - Math.abs(directX));
                }
                if (newY >= 630) {
                    setY(getY() - Math.abs(directY));
                }
                moveCounter--;
            }
            int tmpEat = getEat();
            setEat(--tmpEat);
        }
        if (getId() == ID.PlayerKiwiYoung) {
            grow++;
            if (grow == 500) {
                setId(ID.PlayerKiwi);
                System.out.println("Kiwi Grow up and can do multiplication");
            }
        } else {
            if (getEat() <= 200) {
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
            eat--;
            if(eat == 0){
                setId(ID.PlayerKiwiKill);
            }
        } else {
            g.setColor(Color.white);
        }
        g.fillRect(getX(), getY(), 5, 5);

    }
}
