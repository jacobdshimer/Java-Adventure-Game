package com.jacob.adventuregame.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private String path;
    public final int SIZE;
    public int[] pixels;

    public static SpriteSheet outside = new SpriteSheet("/textures/city/citytiles.png", 256);
    public static SpriteSheet chracters = new SpriteSheet("/textures/characters/characters_transparent.png", 256);
    public static SpriteSheet spawn_assets = new SpriteSheet("/textures/Assets/SpawnAssets/SpawnAssets.png", 64);
    public static SpriteSheet wizard_projectile = new SpriteSheet("/textures/Assets/ProjectilesAssets/WizardProjectile.png", 64);

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        pixels = new int [SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0,0,w,h,pixels,0,w);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
