package com.jacob.adventuregame;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.input.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements  Runnable{
    // Display settings
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static String title = "Adventure com.jacob.adventuregame.Game";

    private Thread gameThread;
    private JFrame frame;
    private boolean running = false;
    private Screen screen;
    private Keyboard key;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        frame.addKeyListener(key);
    }

    public synchronized void start() {
        running = true;
        gameThread = new Thread(this, "Display");
        gameThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            //Update 60 times a second
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            //FPS/UPS counter
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frame.setTitle(title + "   |   " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }

        }
        stop();
    }

    int x=0, y=0;
    private void update(){
        key.update();
        x++;
        y++;
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render(x, y);
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        g.dispose();
        bs.show();
    }

    public static  void main (String[] args) {
        Game game = new Game();
        game.frame.setTitle(Game.title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
