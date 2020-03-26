package com.example;

import java.awt.*;
import java.util.LinkedList;


public class Handler {

    //lista przechowywujaca obiekty
    LinkedList<GameObject> object = new LinkedList<>();
    LinkedList<GameObject> sepList;

    //ustawianie parametrow kazdego obiektu
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void checkAttack() {
        sepList = new LinkedList<>();
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            if (tempObject.id == ID.PlayerSep) {
                sepList.add(tempObject);
            }
        }


        for (int i = 0; i < object.size(); i++) {
                for (int j = 0; j < sepList.size(); j++) {
                    if (object.get(i).getX() == sepList.get(j).getX()) {
                        if (object.get(i).getY() == sepList.get(j).getY()) {
                            if (object.get(i).getId() == ID.PlayerKiwi) {
                                System.out.println(object.get(i).id);
                                removeObject(object.get(i));
                        }
                    }
                }

            }
        }
    }


    //renderowanie obiektu
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }

    }


    public void addObject(GameObject object) {
        this.object.add(object);

    }

    public void removeObject(GameObject object) {
        System.out.println("REMOVE / Remains " + this.object.size());
        this.object.remove(object);
    }
}
