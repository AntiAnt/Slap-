package com.mike.slap;


import com.badlogic.gdx.math.Rectangle;

public class Blocker {
    private Rectangle blocker;

    public Blocker(Rectangle blocker){
        this.blocker = blocker;
    }

    public int getBlockerHeight(){
        return (int) this.blocker.height;
    }
    public int getBlockerWidth() {
        return (int) this.blocker.width;
    }
    public int getBlockerX() {
        return (int) blocker.x;
    }
    public int getBlockerY() {
        return (int) blocker.y;
    }
    public boolean inBlocker(int x, int y) {
        return this.blocker.contains(x,y);
    }

    public void moveBlocker(int x) {
        this.blocker.x += x;
    }
}
