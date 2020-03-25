package com.example;

import java.awt.*;
import java.util.LinkedList;


public class Handler {

    //lista przechowywujaca obiekty
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    //ustawianie parametrow kazdego obiektu
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();

        }
    }

    //renderowanie obiektu
    public void render(Graphics g){
        for(int i= 0 ; i<object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);

        }
    }


    public void addObject(GameObject object){
        this.object.add(object);

    }
    public void removeObject(GameObject object){
        this.object.remove(object);

    }
}
