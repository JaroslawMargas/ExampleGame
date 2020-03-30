package com.example;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;


public class Handler {

    int maxObjects = 100;

    //lista przechowywujaca obiekty
    LinkedList<GameObject> playerObjects = new LinkedList<>();
    LinkedList<GameBoard> boardObjects = new LinkedList<>();

    //ustawianie parametrow kazdego obiektu
    public void tick() {
        for (int i = 0; i < playerObjects.size(); i++) {
            GameObject tempObject = playerObjects.get(i);

            tempObject.tick();
        }

        for (int i = 0; i < boardObjects.size(); i++) {
            GameBoard tmpGameBoard = boardObjects.get(i);

            tmpGameBoard.tick();
        }
    }

    public void livePlayers() {
        LinkedList<GameObject> toRemove = new LinkedList<>();

        for (int i = 0; i < playerObjects.size(); i++) {

            // dodaj eat do kiwi jesli napotkal trawe zeby nie umarl
            if (playerObjects.get(i).getId() == ID.PlayerKiwi) {
                GameObject tempObject = playerObjects.get(i);

                for (int j = 0; j < boardObjects.size(); j++) {
                    GameBoard tempBoard = boardObjects.get(j);
                    if (tempObject.getX() == tempBoard.getX()) {
                        if (tempObject.getY() == tempBoard.getY()) {
                            int tmpEat = tempObject.getEat();
                            System.out.println("EAT " + tempObject.getId());
                            tempObject.setEat(tmpEat + 1000);
                            System.out.println("Remains Eat " + tempObject.getEat());
                        }
                    }
                }
            }

            for (int j = i+1; j < playerObjects.size(); j++) {
                if (playerObjects.get(i) != playerObjects.get(j)) {

                    // relacja kiwi - sep , kiwi joung - sep
                    if (playerObjects.get(i).getId() == ID.PlayerKiwi || playerObjects.get(i).getId() == ID.PlayerKiwiYoung ||
                            playerObjects.get(i).getId() == ID.PlayerKiwiKill) {

                        // multiplication kiwi - kiwi
                        if (playerObjects.size() <= maxObjects) {
                            if (playerObjects.get(i).getId() == ID.PlayerKiwi) {
                                if (playerObjects.get(j).getId() == ID.PlayerKiwi) {
                                    if (playerObjects.get(i).getX() == playerObjects.get(j).getX()) {
                                        if (playerObjects.get(i).getY() == playerObjects.get(j).getY()) {
                                            PlayerKiwi tmp = new PlayerKiwi(playerObjects.get(i).getX() +
                                                    PlayerKiwi.randomMove(),
                                                    playerObjects.get(i).getY() + PlayerKiwi.randomMove(),
                                                    0,0, ID.PlayerKiwiYoung, 0,0);
                                            addObject(tmp);
                                            System.out.println("New " + tmp.getId());
                                            System.out.println("Remains " + playerObjects.size());
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        // sep attack kiwi
                        if (playerObjects.get(j).getId() == ID.PlayerSep) {
                            if (playerObjects.get(i).getX() == playerObjects.get(j).getX()) {
                                if (playerObjects.get(i).getY() == playerObjects.get(j).getY()) {
                                    System.out.println("Removed " + playerObjects.get(i).id);
                                    System.out.println("Remains " + playerObjects.size());
                                    toRemove.add(playerObjects.get(i));
                                }
                            }
                        }

                        // dodaj kiwi kill do usuniecia
                        if (playerObjects.get(i).getId() == ID.PlayerKiwiKill) {
                            toRemove.add(playerObjects.get(i));
                        }
                    }
                }
            }
        }
        for (GameObject ob : toRemove) {
            removeObject(ob);
        }
    }

    //renderowanie obiektu
    public void render(Graphics g) throws IOException {
        for (int i = 0; i < playerObjects.size(); i++) {
            GameObject tempObject = playerObjects.get(i);

            tempObject.render(g);
        }
        for (int i = 0; i < boardObjects.size(); i++) {
            GameBoard tmpGameBoard = boardObjects.get(i);

            tmpGameBoard.render(g);
        }
    }


    public void addObject(GameObject object) {
        this.playerObjects.add(object);
    }

    public void removeObject(GameObject object) {
        this.playerObjects.remove(object);
    }

    public void addObjectBoard(GameBoard object) {
        this.boardObjects.add(object);
    }

    public void removeObjectBoard(GameBoard object) {
        this.boardObjects.remove(object);
    }
}
