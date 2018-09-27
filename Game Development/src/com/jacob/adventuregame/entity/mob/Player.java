package com.jacob.adventuregame.entity.mob;

import com.jacob.adventuregame.graphics.Screen;
import com.jacob.adventuregame.graphics.Sprite;
import com.jacob.adventuregame.input.Keyboard;

public class Player extends Mob{

    private Sprite sprite;
    private Keyboard input;
    private int anim = 0;
    private boolean walking = false;

    public Player(Keyboard input){
        this.sprite = Sprite.player_BACK;
        this.input = input;
    }

    //Spawn player at a specific location
    public Player(int x, int y, Keyboard input){
        this.sprite = Sprite.player_BACK;
        this.input = input;
        this.x = x;
        this.y = y;
    }

    public void update(){
        int xa = 0, ya = 0;

        if (anim < 7500) {
            anim++;
        } else {
            anim = 0;
        }

        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) {
            walking = true;
            move(xa, ya);
        } else {
            walking = false;
        }
    }

    public void render(Screen screen){
        int flip = 0;

        //Walking away from screen
        if (dir == 0) {
            sprite = Sprite.player_BACK;
            if (walking) {
                if (anim % 40 > 30) {
                    sprite = Sprite.player_BACK_1;
                } else {
                    if (anim % 40 > 20){
                        sprite = Sprite.player_BACK;
                    } else {
                        if (anim % 40 > 10) {
                            sprite = Sprite.player_BACK_2;
                        } else {
                            sprite = Sprite.player_BACK;
                        }
                    }
                }
            }
        }

        //Walking east
        if (dir == 1) {
            sprite = Sprite.player_SIDE;
            if (walking) {
                if (anim % 40 > 30) {
                    sprite = Sprite.player_SIDE_1;
                } else {
                    if (anim % 40 > 20){
                        sprite = Sprite.player_SIDE;
                    } else {
                        if (anim % 40 > 10) {
                            sprite = Sprite.player_SIDE_2;
                        } else {
                            sprite = Sprite.player_SIDE;
                        }
                    }
                }
            }
        }

        //Walking toward screen
        if (dir == 2) {
            sprite = Sprite.player_FRONT;
            if (walking) {
                if (anim % 40 > 30) {
                    sprite = Sprite.player_FRONT_1;
                } else {
                    if (anim % 40 > 20){
                        sprite = Sprite.player_FRONT;
                    } else {
                        if (anim % 40 > 10) {
                            sprite = Sprite.player_FRONT_2;
                        } else {
                            sprite = Sprite.player_FRONT;
                        }
                    }
                }
            }
        }

        //Walking west
        if (dir == 3) {
            sprite = Sprite.player_SIDE;
            flip = 1;
            if (walking) {
                if (anim % 40 > 30) {
                    sprite = Sprite.player_SIDE_1;
                } else {
                    if (anim % 40 > 20){
                        sprite = Sprite.player_SIDE;
                    } else {
                        if (anim % 40 > 10) {
                            sprite = Sprite.player_SIDE_2;
                        } else {
                            sprite = Sprite.player_SIDE;
                        }
                    }
                }
            }
        }

        screen.renderPlayer(x, y, sprite, flip);
    }
}
