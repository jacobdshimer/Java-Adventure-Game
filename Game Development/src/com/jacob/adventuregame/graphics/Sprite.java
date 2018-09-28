package com.jacob.adventuregame.graphics;

public class Sprite {
    public final int SIZE;
    private int x, y;
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


    //Level One
//    x1y1 C08C5A
    public static Sprite x1y1 = new Sprite(16,1,1,SpriteSheet.outside);
//    x0y3 B48355
    public static Sprite x0y3 = new Sprite(16,0,3,SpriteSheet.outside);
//    x1y3 B48345
    public static Sprite x1y3 = new Sprite(16,1,3,SpriteSheet.outside);
//    x0y1 B48335
    public static Sprite x0y1 = new Sprite(16,0,1,SpriteSheet.outside);
//    x0y2 B48325
    public static Sprite x0y2 = new Sprite(16,0,2,SpriteSheet.outside);
//    x0y4 0C8325
    public static Sprite x0y4 = new Sprite(16,0,4,SpriteSheet.outside);
//    x1y7 C08C4A
    public static Sprite x1y7 = new Sprite(16,1,7,SpriteSheet.outside);
//    x0y7 C08C3A
    public static Sprite x0y7 = new Sprite(16,0,7,SpriteSheet.outside);
//    x0y6 C08C2A
    public static Sprite x0y6 = new Sprite(16,0,6,SpriteSheet.outside);
//    x3y7 C08C1A
    public static Sprite x3y7 = new Sprite(16,3,7,SpriteSheet.outside);
//    x2y7 C08C0A
    public static Sprite x2y7 = new Sprite(16,2,7,SpriteSheet.outside);
//    x4y7 C07C0A
    public static Sprite x4y7 = new Sprite(16,4,7,SpriteSheet.outside);
//    x4y6 C06C0A
    public static Sprite x4y6 = new Sprite(16,4,6,SpriteSheet.outside);
//    x0y5 C05C0A
    public static Sprite x0y5 = new Sprite(16,0,5,SpriteSheet.outside);
//    x1y5 C04C0A
    public static Sprite x1y5 = new Sprite(16,1,5,SpriteSheet.outside);
//    x3y2 C03C0A
    public static Sprite x3y2 = new Sprite(16,3,2,SpriteSheet.outside);



    public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

    public Sprite (int size, int x, int y, SpriteSheet sheet){
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    public void setColor(int color) {
        for (int i = 0; i < SIZE*SIZE; i++){
            pixels[i] = color;
        }
    }

    private void load() {
        for (int y = 0; y < SIZE; y++){
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

}
