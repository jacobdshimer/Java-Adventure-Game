package com.jacob.adventuregame.level;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.level.tile.Tile;

public class Level {
    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;

    public static Level spawn = new SpawnLevel("/levels/spawn_level.png");

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    protected void generateLevel() {

    }

    protected void loadLevel(String path) {

    }

    public void update() {

    }

    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen){
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);

            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tiles[x + y * width] == Tile.col_spawn_grass) return Tile.spawn_grass;
        if (tiles[x + y * width] == Tile.col_spawn_dirt) return Tile.spawn_dirt;
        if (tiles[x + y * width] == Tile.col_spawn_grey_brick_road_01) return Tile.spawn_grey_brick_road_01;
        if (tiles[x + y * width] == Tile.col_spawn_grey_brick_road_02) return Tile.spawn_grey_brick_road_02;
        if (tiles[x + y * width] == Tile.col_spawn_grey_wall_01) return Tile.spawn_grey_wall_01;
        if (tiles[x + y * width] == Tile.col_spawn_wood_floor_01) return Tile.spawn_wood_floor_01;
        if (tiles[x + y * width] == Tile.col_spawn_hedge) return Tile.spawn_hedge;
        return Tile.voidTile;
    }
}
