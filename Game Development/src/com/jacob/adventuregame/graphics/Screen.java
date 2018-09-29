package com.jacob.adventuregame.graphics;

import com.jacob.adventuregame.entity.projectile.Projectile;
import com.jacob.adventuregame.level.tile.Tile;

import java.util.Random;

public class Screen {
    public int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int xOffset, yOffset;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private Random random = new Random();

    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width*height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
        if (fixed) {
            xp -= xOffset;
            yp -= yOffset;
        }
        for (int y = 0; y < sprite.getHeight(); y++){
            int ya = y + yp;
            for (int x = 0; x < sprite.getWidth(); x++){
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
                pixels[xa + ya * width] = sprite.pixels[x + y * sprite.getWidth()];
            }
        }
    }
    public  void renderTile(int xp, int yp, Tile tile){
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++){
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xa = x + xp;
                if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if ( xa < 0 ) xa = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public  void renderTile(int xp, int yp, Sprite sprite){
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < sprite.SIZE; y++){
            int ya = y + yp;
            for (int x = 0; x < sprite.SIZE; x++) {
                int xa = x + xp;
                if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if ( xa < 0 ) xa = 0;
                pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
            }
        }
    }

    public  void renderProjectile(int xp, int yp, Projectile projectile){
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < projectile.getSprite().SIZE; y++){
            int ya = y + yp;
            for (int x = 0; x < projectile.getSprite().SIZE; x++) {
                int xa = x + xp;
                if (xa < -projectile.getSprite().SIZE || xa >= width || ya < 0 || ya >= height) break;
                if ( xa < 0 ) xa = 0;

                int col = projectile.getSprite().pixels[x + y * projectile.getSprite().SIZE];
                if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
            }
        }
    }

    public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < sprite.SIZE; y++){
            int ya = y + yp;

            //Sprite y
            int ys = y;
            if (flip == 2 || flip == 3) ys = 15 - y;

            for (int x = 0; x < sprite.SIZE; x++) {
                int xa = x + xp;
                //Sprite x
                int xs = x;
                if (flip == 1 || flip == 3) xs = 15 - x;

                if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if ( xa < 0 ) xa = 0;
                int col = sprite.pixels[xs + ys * sprite.SIZE];
                //Make pink transparent
                if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
            }
        }
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
