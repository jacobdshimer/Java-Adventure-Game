package com.jacob.adventuregame;

import com.jacob.adventuregame.entity.mob.Player;
import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.graphics.Sprite;
import com.jacob.adventuregame.input.Keyboard;
import com.jacob.adventuregame.input.Mouse;
import com.jacob.adventuregame.level.Level;
import com.jacob.adventuregame.level.TileCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements  Runnable{
    // Display settings
    private static int width = 300;
    private static int height = width / 16 * 9;
    private static int scale = 3;
    public static String title = "Adventure Game";

    private Thread gameThread;
    private JFrame frame;
    private boolean running = false;
    private Screen screen;
    private Keyboard key;
    private Mouse mouse;
    private Level level;
    private Player player;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        mouse = new Mouse();
        level = Level.spawn;
        TileCoordinate playerSpawn = new TileCoordinate(20, 22);
        player = new Player(playerSpawn.x(), playerSpawn.y(),key);
        player.init(level);

        addKeyListener(key);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    public static int getWindowWidth(){
        return width * scale;
    }

    public static int getWindowHeight() {
        return height * scale;
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
        requestFocus();
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

    private void update(){
        key.update();
        player.update();
        level.update();
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        int xScroll = player.x - (screen.width/2);
        int yScroll = player.y - (screen.height/2);
        level.render(xScroll, yScroll, screen);
        player.render(screen);

        Sprite sprite = new Sprite(80, 80, 0xFF0F0F);
        screen.renderSprite(0, 0, sprite, false);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        //Movement Debugging
//        g.setColor(Color.WHITE);
//        g.setFont(new Font("Verdana", 0, 50));
//        g.drawString("X: " + player.x + ", Y: " + player.y, 350, 400);
//        g.fillRect(Mouse.getX()-32, Mouse.getY()-32, 64, 64);
//        if (Mouse.getButton()!=-1) g.drawString("Button: " + Mouse.getButton(), 80,80 );

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
