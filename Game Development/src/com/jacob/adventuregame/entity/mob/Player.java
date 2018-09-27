package com.jacob.adventuregame.entity.mob;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.graphics.Sprite;
import com.jacob.adventuregame.input.Keyboard;

public class Player extends Mob{

    private Keyboard input;

    public Player(Keyboard input){
        this.input = input;
    }

    //Spawn player at a specific location
    public Player(int x, int y, Keyboard input){
        this.input = input;
        this.x = x;
        this.y = y;
    }

    public void update(){
        int xa = 0, ya = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) move(xa, ya);
    }

    public void render(Screen screen){
        screen.renderPlayer(x, y, Sprite.player0);
    }
}
