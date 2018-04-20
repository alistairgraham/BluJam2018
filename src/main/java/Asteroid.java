
public class Asteroid implements GameObject {
	
	private float x;
	private float y;
	private float vel;
	// PImage img;

	public Asteroid(int x_pos, int y_pos) {
		float velocity = -1;
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
}
