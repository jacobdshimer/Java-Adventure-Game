package com.jacob.adventuregame.level;

import com.jacob.adventuregame.entity.Entity;
import com.jacob.adventuregame.entity.projectile.Projectile;
import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.level.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level {
    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;
    private List<Entity> entities = new ArrayList<Entity>();
    private List<Projectile> projectiles = new ArrayList<Projectile>();

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

    public List<Projectile> getProjectiles(){
        return projectiles;
    }

    protected void generateLevel() {

    }

    protected void loadLevel(String path) {

    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }

        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).update();
        }
    }

    private void time() {

    }

    public boolean tileCollision(double x, double y, double xa, double ya, int size){
        boolean solid = false;
        for (int c = 0; c < 4; c++){
            int xt = ((((int)x + (int)xa) + c % 2 * size * 2 - 6) / 16);
            int yt = ((((int)y + (int)ya) + c / 2 * size + 2) / 16);
            if (getTile(xt, yt).solid()) solid = true;
        }

        return solid;
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

        for (int i = 0; i < entities.size(); i++){
            entities.get(i).render(screen);
        }

        for (int i = 0; i < projectiles.size(); i++){
            projectiles.get(i).render(screen);
        }
    }

    public void add(Entity e){
        entities.add(e);
    }

    public void addProjectile(Projectile p){
        p.init(this);
        projectiles.add(p);
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
