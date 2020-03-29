package com.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

// klasa implemetujaca Runnable wykonywana w osobnym watku start()
// klasa Game rozszerzona o klase Canvas
public class Game extends Canvas implements Runnable {

    // test branch

    // stale wielkosc okna
    public static final int WIDTH = 640;
    public static final int HEIGHT = 640;

    // nowy watek
    private Thread thread;
    // bool do zatrzymania i uruchaminia watku
    private boolean running = false;

    private Handler handler = new Handler();


    // konstruktor tworzy pierwsza pozycje obiektow
    public Game() throws IOException {
        new Window(WIDTH, HEIGHT, "Lets build a game", this);

        // zmienne trawy
        BufferedImage imgGrass = ImageIO.read(new File("grass.gif"));
        int wGrass = imgGrass.getWidth(null);
        int hGrass = imgGrass.getHeight(null);

        // instancja planszy losowa
        Random r = new Random();

        // buduj obiekty planszy
        for (int i = 0; i < 20; i++) {
            handler.addObjectBoard(new Grass(r.nextInt(WIDTH - 20), r.nextInt(HEIGHT - 40), ID.Grass,
                    imgGrass, wGrass, hGrass));
        }

        // buduj obiekty player Kiwi
        for (int i = 0; i < 20; i++) {
            handler.addObject(new PlayerKiwi(r.nextInt(WIDTH - 20), r.nextInt(HEIGHT - 40),
                    0, 0, ID.PlayerKiwi, 0, 0));
        }

        // buduj obiekty player Kiwi
        for (int i = 0; i < 20; i++) {
            handler.addObject(new PlayerSep(r.nextInt(WIDTH - 20), r.nextInt(HEIGHT - 40),
                    0, 0, ID.PlayerSep, 0, 0));
        }
    }

    // uruchamiania watku thread
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    // zatrzymanie watku thread
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // game loop in thread
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                try {
                    render();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }


    public void tick() {
        handler.tick();

    }

    // funkcja renderujca i ilosc bufferow (3) bedzie tworzonych do renderowania
    public void render() throws IOException {
        // Create a general double-buffering strategy
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        // graphic g = creates a graphics context for the drawing buffer.
        Graphics g = bs.getDrawGraphics();
        // color background
        g.setColor(Color.YELLOW);
        g.fillRect(2, 0, WIDTH, HEIGHT);

        // disposes of this graphics context and releases any system resources that it is using.
        // a Graphics object cannot be used after disposehas been called.

        handler.render(g);

        g.dispose();
        // display the buffer
        bs.show();

        handler.livePlayers();

    }

    public static void main(String[] args) throws IOException {
        new Game();
    }
}
