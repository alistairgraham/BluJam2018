package gameObjects;

import gameObjects.GameObject;

public class Asteroid implements GameObject {
	 
	private float x;
	private float y;
	private float vel;
	final float size = 20;
	public final static float screenWidth = 100;
	// PImage img;

	public Asteroid() {
		float velocity = 1;
		reset(velocity);
	}
	
	public void update() {
		if (x < 0 || x > screenWidth) {
			x = Math.min(screenWidth, Math.max(x, 0));
		}
	}
	
	public void draw() {
		
	}
	
	public void reset(float velocity) {
		this.x = (float) Math.random();  //need to change this for width
		this.y = 0;
		this.vel = velocity;
	}
	
	//----------------------------------Getter and setters------------------------//
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVel() {
		return vel;
	}

	public void setVel(float vel) {
		this.vel = vel;
	}
	//-------------------------------------------------------------------------------//
	
	
}
