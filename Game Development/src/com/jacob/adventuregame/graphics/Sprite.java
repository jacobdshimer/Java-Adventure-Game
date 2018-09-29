package com.jacob.adventuregame.graphics;

public class Sprite {
    public final int SIZE;
    private int x, y;
    private int width, height;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16,0,3,SpriteSheet.outside);
    public static Sprite flower = new Sprite(16, 0, 9, SpriteSheet.outside);
    public static Sprite rock = new Sprite(16, 1, 9, SpriteSheet.outside);
    public static Sprite street = new Sprite(16, 3,0, SpriteSheet.outside);
    public static Sprite dirt = new Sprite(16, 0, 5, SpriteSheet.outside);
    public static Sprite sand = new Sprite(16, 0, 6, SpriteSheet.outside);

    public static Sprite player_BACK = new Sprite(16, 9, 0, SpriteSheet.chracters);
    public static Sprite player_BACK_1 = new Sprite(16, 9, 1, SpriteSheet.chracters);
    public static Sprite player_BACK_2 = new Sprite(16, 9, 2, SpriteSheet.chracters);

    public static Sprite player_FRONT= new Sprite(16, 8, 0, SpriteSheet.chracters);
    public static Sprite player_FRONT_1= new Sprite(16, 8, 1, SpriteSheet.chracters);
    public static Sprite player_FRONT_2= new Sprite(16, 8, 2, SpriteSheet.chracters);

    public static Sprite player_SIDE = new Sprite(16, 10, 0,SpriteSheet.chracters);
    public static Sprite player_SIDE_1 = new Sprite(16, 10, 1,SpriteSheet.chracters);
    public static Sprite player_SIDE_2 = new Sprite(16, 10, 2,SpriteSheet.chracters);

    //Spawn Assets
    //FF409C62
    public static Sprite spawn_grass = new Sprite(16,0,0,SpriteSheet.spawn_assets);
    //FFB48355
    public static Sprite spawn_dirt = new Sprite(16,1,0,SpriteSheet.spawn_assets);
    //FF9DAAAB
    public static Sprite spawn_grey_brick_road_01 = new Sprite(16,2,0,SpriteSheet.spawn_assets);
    //FF94A1A2
    public static Sprite spawn_grey_brick_road_02 = new Sprite(16,2,3,SpriteSheet.spawn_assets);
    //FF7F8286
    public static Sprite spawn_grey_wall_01 = new Sprite(16,0,1,SpriteSheet.spawn_assets);
    public static Sprite spawn_grey_wall_02 = new Sprite(16,0,3,SpriteSheet.spawn_assets);
    public static Sprite spawn_red_wall_01 = new Sprite(16,1,1,SpriteSheet.spawn_assets);
    public static Sprite spawn_red_wall_02 = new Sprite(16,1,3,SpriteSheet.spawn_assets);
    //FF695333
    public static Sprite spawn_wood_floor_01 = new Sprite(16,0,2,SpriteSheet.spawn_assets);
    public static Sprite spawn_wood_floor_02 = new Sprite(16,1,2,SpriteSheet.spawn_assets);
    public static Sprite spawn_plain_wall = new Sprite(16,2,1,SpriteSheet.spawn_assets);
    //FF20500A
    public static Sprite spawn_hedge = new Sprite(16,2,2,SpriteSheet.spawn_assets);

    //Projectile Assets
    public static Sprite small_pink_missile = new Sprite(16, 0,0,SpriteSheet.wizard_projectile);
    public static Sprite med_pink_missile = new Sprite(16, 1,0,SpriteSheet.wizard_projectile);



    //Void Sprite
    public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

    public Sprite (int width, int height, int color) {
        SIZE = 0;
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        setColor(color);
    }
    public Sprite (int size, int x, int y, SpriteSheet sheet){
        SIZE = size;
        this.width = size;
        this.height = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        this.width = size;
        this.height = size;
        pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    public void setColor(int color) {
        for (int i = 0; i < width*height; i++){
            pixels[i] = color;
        }
    }


    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    private void load() {
        for (int y = 0; y < SIZE; y++){
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

}
