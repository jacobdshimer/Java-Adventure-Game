package com.jacob.adventuregame.entity.projectile;

import com.jacob.adventuregame.entity.Entity;
import com.jacob.adventuregame.graphics.Sprite;

public abstract class Projectile extends Entity {

    protected final int xOrigin, yOrigin;
    protected double angle;
    protected Sprite sprite;
    protected double x, y;
    protected double nx, ny;
    //Projectile Modifiers
    protected double speed, range, damage;

    public Projectile(int x, int y, double dir) {
        xOrigin = x;
        yOrigin = y;
        angle = dir;
        this.x = x;
        this.y = y;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void move(){

    }


}
