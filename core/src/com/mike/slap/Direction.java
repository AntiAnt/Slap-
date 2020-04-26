package com.mike.slap;

public enum Direction {
    LEFT(-1, 0),
    RIGHT(1, 0),
    LEFTUP(-1,1),
    LEFTDOWN(-1,-1),
    RIGHTUP(1, 1),
    RIGHTDOWN(1, -1);

    private int x;
    private int y;

    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
