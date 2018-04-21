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
		initialVelocity = new PVector(0,1/2);
		velocity = new PVector(0, 2); // Default velocity vector
		this.diam = diameter;
	}

	@Override
	public void draw(PApplet pApplet) {
        PVector rV = new PVector(-velocity.x, -velocity.y).mult(10);
        PVector pV = new PVector(velocity.y, -velocity.x).normalize().mult(diam/2);
        pApplet.fill(pApplet.color(249, 181, 59));
        PVector p1 = rV.add(new PVector(rV.x, rV.y).normalize().mult(20)).add(position);
        pApplet.triangle(p1.x, p1.y,
                position.x+pV.x, position.y+pV.y,
                position.x-pV.x, position.y-pV.y);
		pApplet.fill(pApplet.color(112, 21, 13));
		pApplet.ellipse(position.x, position.y, diam, diam);


		//pApplet
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public void update(App app){
	    velocity.add(0,1/10); // Temporary value for velocity
		position.add(velocity);
		position.x = Math.min(app.width - 1, Math.max(0, position.x));
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
