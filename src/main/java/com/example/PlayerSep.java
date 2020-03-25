package com.example;

import java.awt.*;

public class PlayerSep extends Player {

    public PlayerSep(int x, int y, ID id) {
        super(x, y, id);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 5, 5);

    }
}
