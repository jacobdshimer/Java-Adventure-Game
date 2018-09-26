package com.jacob.adventuregame.entity;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.level.Level;

import java.util.Random;

public abstract class Entity {
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public void update(){

    }

    public void render(Screen screen) {

    }

    public void remove() {
        //Remove from level
        removed = true;
    }

    public boolean isRemoved() {
        //Check if removed
        return removed;
    }
}
