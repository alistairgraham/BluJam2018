import processing.core.PApplet;
import processing.core.PVector;

public class Asteroid implements Drawable {

	private PVector position;
	private PVector velocity;

	public Asteroid() {

	}

	@Override
	public void draw(PApplet pApplet) {

	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public void update(App app){

	}

	public PVector getPosition() {
		return position;
	}

	public void setPosition(PVector position) {
		this.position = position;
	}

	public PVector getVelocity() {
		return velocity;
	}

	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}
}
