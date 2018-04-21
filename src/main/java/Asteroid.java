import processing.core.PApplet;
import processing.core.PVector;

public class Asteroid implements Drawable {

	private PVector initialPosition;
	private PVector initialVelocity;

	private PVector position;
	private PVector velocity;
	private float diam;

	public Asteroid(float xPos, float yPos, float diameter) {
		initialPosition = new PVector(xPos, yPos);
		position = new PVector(xPos, yPos);
		initialVelocity = new PVector(0,0);
		velocity = new PVector(0, 0); // Default velocity vector
		this.diam = diameter;
	}

	@Override
	public void draw(PApplet pApplet) {
		pApplet.fill(pApplet.color(79, 47, 9));
		pApplet.ellipse(position.x, position.y, diam, diam);
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public void update(App app){
		position.add(velocity);
		position.x = Math.min(app.width - 1, Math.max(0, position.x));
		velocity.add(0,1); // Temporary value for velocity
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

	public void reset(){
		position = initialPosition.copy();
		velocity = initialVelocity.copy();
	}
}
