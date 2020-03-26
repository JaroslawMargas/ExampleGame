package com.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Handler {

    //lista przechowywujaca obiekty
    LinkedList<GameObject> object = new LinkedList<>();
    LinkedList<GameObject> sepList;
    LinkedList<GameObject> kiwiList;

    //ustawianie parametrow kazdego obiektu
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void checkAttack() {
        LinkedList<GameObject> toRemove = new LinkedList<>();

        for (int i = 0; i < object.size(); i++) {
            for (int k = 0; k < object.size(); k++) {
                if (object.get(i) != object.get(k)) {

                    // relacja kiwi - sep , kiwi joung - sep
                    if (object.get(i).getId() == ID.PlayerKiwi || object.get(i).getId() == ID.PlayerKiwiYoung ||object.get(i).getId() == ID.PlayerKiwiKill) {
                        // multiplication kiwi - kiwi
                        if (object.get(i).getId() == ID.PlayerKiwi) {
                            if (object.get(k).getId() == ID.PlayerKiwi) {
                                if (object.get(i).getX() == object.get(k).getX()) {
                                    if (object.get(i).getY() == object.get(k).getY()) {
                                        PlayerKiwi tmp = new PlayerKiwi(object.get(i).getX() + PlayerKiwi.randomMove(),
                                                object.get(i).getY() + PlayerKiwi.randomMove(), ID.PlayerKiwiYoung, 0);
                                        addObject(tmp);
                                        System.out.println("New " + tmp.getId());
                                        System.out.println("Remains " + object.size());
                                        break;
                                    }

                                }

                            }
                        }
                        // sep attack kiwi
                        if (object.get(k).getId() == ID.PlayerSep) {
                            if (object.get(i).getX() == object.get(k).getX()) {
                                if (object.get(i).getY() == object.get(k).getY()) {
                                    System.out.println("Removed " + object.get(i).id);
                                    System.out.println("Remains " + object.size());
                                    toRemove.add(object.get(i));
                                }
                            }


                        }
                        if(object.get(i).getId() == ID.PlayerKiwiKill){
                            toRemove.add(object.get(i));
                        }
                    }
                }
            }
        }
        for(GameObject ob : toRemove){
            removeObject(ob);
        }




    }
//        sepList = new LinkedList<>();
//        for (int i = 0; i < object.size(); i++) {
//            GameObject tempObject = object.get(i);
//            if (tempObject.id == ID.PlayerSep) {
//                sepList.add(tempObject);
//            }
//        }
//        kiwiList = new LinkedList<>();
//        for (int i = 0; i < object.size(); i++) {
//            GameObject tempObject = object.get(i);
//            if (tempObject.id == ID.PlayerKiwi) {
//                kiwiList.add(tempObject);
//            }
//        }
//
//
//        for (int i = 0; i < object.size(); i++) {
//            // rozmnazanie kiwi
//            for (int k = 0; k < kiwiList.size(); k++) {
//                // pomin obiekt Kiwi z Lista kiwi ten sam
//                if (!object.get(i).equals(kiwiList.get(k))) {
//                    // jezeli x i y te same
//                    if (object.get(i).getX() == kiwiList.get(k).getX()) {
//                        if (object.get(i).getY() == kiwiList.get(k).getY()) {
//                            // jezeli jest Kiwi
//                            if (object.get(i).getId() == ID.PlayerKiwi) {
//                                PlayerKiwi tmp = new PlayerKiwi(object.get(i).getX() + PlayerKiwi.randomMove(),
//                                        object.get(i).getY() + PlayerKiwi.randomMove(), ID.PlayerKiwiYoung, 0);
//                                addObject(tmp);
//                                System.out.println("New " + tmp.getId());
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//
//            // atak Sepa na Kiwi
//            for (int j = 0; j < sepList.size(); j++) {
//                if (object.get(i).getX() == sepList.get(j).getX()) {
//                    if (object.get(i).getY() == sepList.get(j).getY()) {
//                        if (object.get(i).getId() == ID.PlayerKiwi) {
//                            System.out.println("Removed " + object.get(i).id);
//                            System.out.println("Remains " + object.size());
//                            removeObject(object.get(i));
//                        }
//                        if(object.get(i).getId() == ID.PlayerSep){
//                            int tmpEat = object.get(i).getEat();
//
//                        }
//                    }
//                }
//            }
//        }
//    }


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
        this.object.remove(object);
    }
}
