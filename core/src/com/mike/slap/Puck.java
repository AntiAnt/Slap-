package com.mike.slap;

import com.badlogic.gdx.math.Circle;

public class Puck {
    public Direction state;
    private Circle puck;

    public Puck(Circle circle, String direction){
        this.puck = circle;
        this.state = Direction.valueOf(direction.toUpperCase());
    }

    public float getPuckX(){
        return this.puck.x;
    }
    public float getPuckY(){
        return this.puck.y;
    }
    public float getPuckRadius(){
        return this.puck.radius;
    }
    // increments puck x coordinate
    public void incPuckX(float x){
        this.puck.x += (int) x;
    }
    //increments puck y coordinate
    public void incPuckY(float y){
        this.puck.y += (int) y;
    }

}
