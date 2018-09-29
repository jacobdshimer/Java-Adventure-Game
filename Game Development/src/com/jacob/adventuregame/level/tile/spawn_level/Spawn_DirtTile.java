package com.jacob.adventuregame.level.tile.spawn_level;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.graphics.Sprite;
import com.jacob.adventuregame.level.tile.Tile;

public class Spawn_DirtTile extends Tile {

    public Spawn_DirtTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}