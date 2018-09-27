package com.jacob.adventuregame.entity.mob;

import com.jacob.adventuregame.entity.Entity;
import com.jacob.adventuregame.graphics.Sprite;

public abstract class Mob extends Entity {
    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move(int xa, int ya){
        //east
        if (xa > 0) dir = 1;
        //west
        if (xa < 0) dir = 3;
        //south
        if (ya > 0) dir = 2;
        //north
        if (ya < 0) dir = 0;

        //Add if no collisions detected
        if(!collision()){
            x += xa;
            y += ya;
        }
    }

    public void update(){

    }

    public void render(){

    }

    private boolean collision(){
        return false;
    }
}
