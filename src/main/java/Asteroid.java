import processing.core.PImage;

public class Asteroid extends LayerObject {
//	final float size = 20;
// 	public final static float screenWidth = 100;
//	PImage img;

	/**
	 * Construct an asteroid object
	 * @param xPos The starting x position
	 * @param yPos The starting y position
	 * @param xVel The starting x velocity
	 * @param yVel The starting y velocity
	 */
	public Asteroid(float xPos, float yPos, float xVel, float yVel) {
		super(xPos, yPos, xVel, yVel);
		// some other setup functionality could occur here
	}
	
//	public void update(float dx) {
//		if (x < 0) {
//			dx = 0;
//			x = 0;
//		}
//		else if (x > screenWidth) {
//			dx = 0;
//			x = screenWidth;
//		}
//
//	}
	
	public void draw() {
		// todo sort out how to draw asteroid please @Callum Li <3
		// todo layer object could import PImage and each layer object could store it's own PImage?
	}

//	/**
//	 * Reset the asteroid to it's initial position
//	 */
//	public void reset() {
//		this.xPos = 0;
//		this.yPos = 0;
//		this.dy = dy;
//	}
	
}
