package com.jacob.adventuregame.entity.mob;

import com.jacob.adventuregame.entity.Entity;
import com.jacob.adventuregame.entity.projectile.Projectile;
import com.jacob.adventuregame.entity.projectile.WizardProjectile;
import com.jacob.adventuregame.graphics.Sprite;

public abstract class Mob extends Entity {
    protected Sprite sprite;
    protected int dir = 0;
    protected boolean walking = false;
    protected boolean moving = false;


    public void move(int xa, int ya){
        if (xa != 0 && ya != 0) {
            move(xa,0);
            move(0,ya);
            return;
        }
        //east
        if (xa > 0) dir = 1;
        //west
        if (xa < 0) dir = 3;
        //south
        if (ya > 0) dir = 2;
        //north
        if (ya < 0) dir = 0;

        //Add if no collisions detected
        if(!collision(xa, ya)){
            x += xa;
            y += ya;
        }
    }

    public void update(){

    }

    public void render(){

    }

    private boolean collision(int xa, int ya){
        boolean solid = false;
        for (int c = 0; c < 4; c++){
            int xt = (((x + xa) + c % 2 * 9 + 3) / 16);
            int yt = (((y + ya) + c / 2 * 12 + 3) / 16);
            if (level.getTile(xt, yt).solid()) solid = true;
        }

        return solid;
    }

    protected void shoot(int x, int y, double dir){
        //dir = Math.toDegrees(dir);
        Projectile p = new WizardProjectile(x, y, dir);
        level.addProjectile(p);

    }

}
