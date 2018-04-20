
public class Asteroid implements GameObject {
	 
	private float x;
	private float y;
	private float vel;
	final float size = 20;
	// PImage img;

	public Asteroid(int x_pos, int y_pos) {
		float velocity = 1;
		reset(x_pos, y_pos, velocity);
	}
	
	public void update() {
		
	}
	
	public void draw() {
		
	}
	
	public void reset(float x_pos, float y_pos, float velocity) {
		this.x = x_pos;
		this.y = y_pos;
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
