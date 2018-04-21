import processing.core.PApplet;

public class Asteroid implements Drawable {
	 
	private float x;
	private float y;
	private float dx;
	private float dy;
	final float size = 20;
	public final static float screenWidth = 100;
	// PImage img;

	public Asteroid() {
		float dy = 1;
		reset();
	}

	@Override
	public void draw(PApplet pApplet) {

	}

	public void update(float dx) {
	    x += dx;
	    y += dy;

		if (x < 0) {
			this.dx = 0;
			x = 0;
		}
		else if (x > screenWidth) {
            this.dx = 0;
            x = screenWidth;
        }
	}
	
	public void draw() {
		//Draws a black circle
	}
	
	public void reset() {
		this.x = (float) Math.random();  //need to change this for width
		this.y = 0;
		this.dy = dy;
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

	public float getDY() {
		return dy;
	}

	public void setDY(float dy) {
		this.dy = dy;
	}
	
	public float getDX() {
		return dx;
	}

	public void setDX(float dx) {
		this.dx = dx;
	}
	//-------------------------------------------------------------------------------//

}
