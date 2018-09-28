package com.jacob.adventuregame.level.tile;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.graphics.Sprite;
import com.jacob.adventuregame.level.tile.spawn_level.*;

public class Tile {
    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile dirt = new DirtTile(Sprite.dirt);
    public static Tile sand = new SandTile(Sprite.sand);
    public static Tile street = new StreetTile(Sprite.street);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);


    //Spawn Tiles
    public static Tile spawn_grass = new Spawn_GrassTile(Sprite.spawn_grass);
    public static Tile spawn_dirt = new Spawn_DirtTile(Sprite.spawn_dirt);
    public static Tile spawn_grey_brick_road_01 = new Spawn_Road(Sprite.spawn_grey_brick_road_01);
    public static Tile spawn_grey_brick_road_02 = new Spawn_Road(Sprite.spawn_grey_brick_road_02);
    public static Tile spawn_grey_wall_01 = new Spawn_Wall(Sprite.spawn_grey_wall_01);
    public static Tile spawn_grey_wall_02 = new Spawn_Wall(Sprite.spawn_grey_wall_02);
    public static Tile spawn_red_wall_01 = new Spawn_Wall(Sprite.spawn_red_wall_01);
    public static Tile spawn_red_wall_02 = new Spawn_Wall(Sprite.spawn_red_wall_02);
    public static Tile spawn_wood_floor_01 = new Spawn_Floor(Sprite.spawn_wood_floor_01);
    public static Tile spawn_wood_floor_02 = new Spawn_Floor(Sprite.spawn_wood_floor_02);
    public static Tile spawn_plain_wall = new Spawn_Wall(Sprite.spawn_plain_wall);
    public static Tile spawn_hedge = new Spawn_Hedge(Sprite.spawn_hedge);

    public static final int col_spawn_grass = 0xFF409C62;
    public static final int col_spawn_dirt = 0xFFB48355;
    public static final int col_spawn_grey_brick_road_01 = 0xFF9DAAAB;
    public static final int col_spawn_grey_brick_road_02 = 0xFF94A1A2;
    public static final int col_spawn_grey_wall_01 = 0xFF7F8286;
    public static final int col_spawn_wood_floor_01 = 0xFF695333;
    public static final int col_spawn_hedge = 0xFF20500A;



    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {

    }

    public boolean solid() {
        return false;
    }

    public boolean breakable() {
        return false;
    }
}
