package com.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Grass extends GameBoard {
    
    private final Color darkGreen;

    public Grass(int x, int y, ID id, BufferedImage img, int width, int height) {
        super(x, y, id, img, width, height);
        darkGreen = new Color(0, 128, 0);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, getX(), getY(), getWidth(), getHeight(), darkGreen,null);
    }
}
