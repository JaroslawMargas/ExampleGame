package com.example;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    public Window(int width , int height , String title, Game game) {

        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width+20,height+40));
        frame.setSize(new Dimension(width+20,height+40));
        frame.setMinimumSize(new Dimension(width+20,height+40));
//        frame.setMaximumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}
