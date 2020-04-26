package com.mike.slap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Slap extends ApplicationAdapter {
	private Blocker redBlocker;
	private Blocker blueBlocker;
	private Puck puck;
	private OrthographicCamera camera;
	private FitViewport viewport;
	private ShapeRenderer shape;
	private ShapeRenderer blockerBlue;
	private ShapeRenderer blockerRed;
	private int movement;
	private float puckSpeed;


	
	@Override
	public void create () {
		puckSpeed = 2.0f;
		blockerBlue = new ShapeRenderer();
		blockerRed = new ShapeRenderer();
		shape = new ShapeRenderer();
		puck = new Puck(new Circle(400.0f,240.0f,8.0f),"leftup");
		redBlocker= new Blocker( new Rectangle(20, 215, 5, 30));
		blueBlocker = new Blocker(new Rectangle(775, 215, 5, 30));

		camera = new OrthographicCamera();

		camera.setToOrtho(false, 800, 480);
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(204, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//puck shape render
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setColor(Color.BLACK);
		shape.circle(puck.getPuckX(),puck.getPuckY(),puck.getPuckRadius());
		shape.end();

		blockerRed.begin(ShapeRenderer.ShapeType.Filled);
		blockerRed.setColor(Color.RED);
		blockerRed.rect(redBlocker.getBlockerX(),
				redBlocker.getBlockerY(),
				redBlocker.getBlockerWidth(),
				redBlocker.getBlockerHeight()
		);
		blockerRed.end();

		blockerBlue.begin(ShapeRenderer.ShapeType.Filled);
		blockerBlue.setColor(Color.BLUE);
		blockerBlue.rect(blueBlocker.getBlockerX(),
				blueBlocker.getBlockerY(),
				blueBlocker.getBlockerWidth(),
				blueBlocker.getBlockerHeight()
		);
		blockerBlue.end();



		if(puck.getPuckY() == 8){
			if(puck.state == Direction.RIGHTDOWN){
				puck.state = Direction.RIGHTUP;
			}else{
				puck.state = Direction.LEFTUP;
			}
		}
		if(puck.getPuckY() == 472) {
			if(puck.state == Direction.LEFTUP){
				puck.state = Direction.LEFTDOWN;
			}else {
				puck.state = Direction.RIGHTDOWN;
			}
		}
		if(puck.getPuckX() == 8) {
			if (puck.state == Direction.LEFT){
				puck.state = Direction.RIGHT;
			}else if (puck.state == Direction.LEFTDOWN) {
				puck.state = Direction.RIGHTDOWN;
			}else {
				puck.state = Direction.RIGHTUP;
			}
		}
		if (puck.getPuckX() == 792) {
			if (puck.state == Direction.RIGHT) {
				puck.state = Direction.LEFT;
			}else if (puck.state == Direction.RIGHTDOWN) {
				puck.state =  Direction.LEFTDOWN;
			}else {
				puck.state = Direction.LEFTUP;
			}
		}

		puck.incPuckX(puck.state.getX() * puckSpeed);
		puck.incPuckY(puck.state.getY() * puckSpeed);

	}
	
	@Override
	public void dispose () {

	}
}
