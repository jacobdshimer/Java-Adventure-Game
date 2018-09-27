package com.jacob.adventuregame.level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

    public SpawnLevel(String path) {
        super(path);
    }


    protected void loadLevel(String path){
        try{
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
            tiles = new int[w * h];
            image.getRGB(0,0,w,h, tiles,0,w);
        } catch (IOException e){
            System.out.println("Exception! Could not load level file");
            e.printStackTrace();
        }
    }

    //Grass =   0xFF00FF00
    //Flower = 0xFFFFFF00
    //Rock = 0xFF808080
    //Dirt = 0xFF573B0C

    protected void generateLevel() {

    }

}
