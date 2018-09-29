package com.jacob.adventuregame.entity.projectile;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.graphics.Sprite;

public class WizardProjectile extends Projectile {

    public static final int FIRE_RATE = 15;
    public WizardProjectile(int x, int y, double dir) {
        super(x, y, dir);
        range = 100;
        speed = 4;
        damage = 20;
        sprite = Sprite.small_pink_missile;

        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }

    public void update(){
        if (level.tileCollision(x, y, nx, ny, 11)) remove();
        move();
    }

    public void move(){
        x += nx;
        y += ny;
        if (distance() > range) remove();
    }

    private double distance() {
        double dist = 0;
        dist = Math.sqrt((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y));
        return dist;
    }

    public void render(Screen screen){
        screen.renderProjectile((int)x, (int)y, this);
    }
}
