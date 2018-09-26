package com.jacob.adventuregame.level.tile;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.graphics.Sprite;

public class Tile {
    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile dirt = new DirtTile(Sprite.dirt);
    public static Tile sand = new SandTile(Sprite.sand);
    public static Tile street = new StreetTile(Sprite.street);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {

    }

    public boolean solid() {
        return false;
    }
}
