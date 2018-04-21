import processing.core.PApplet;
import processing.core.PVector;

public class Asteroid implements Drawable {

	private PVector initialPosition;
	private PVector initialVelocity;

	private PVector position;
	private PVector velocity;
	private PVector velX;
	private float diam;

	public Asteroid(float xPos, float yPos, float diameter) {
		initialPosition = new PVector(xPos, yPos);
		position = new PVector(xPos, yPos);
		initialVelocity = new PVector(0,2);
		velocity = new PVector(0, 2); // Default velocity vector
        velX = new PVector(-0.2f, 0);
//		position = initialPosition.copy();
//		initialVelocity = new PVector(0,2);
//		velocity = initialVelocity.copy();
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

	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public void update(App app, float dx){
	    velocity.add(0, 1/10); // Temporary value for velocity
		position.add(velocity);
		if(position.x > app.width-1) position.x = 1;
		if(position.x<=0) position.x = app.width-1;
		//position.x = Math.min(app.width - 1, Math.max(0, position.x));
	}

	public void userMove(boolean left){
	    if (left) {
            if (velocity.x>-6) {
                velocity.add(velX);
                if (velocity.x<-6) { velocity.x = -6; }
            }
            position.add(velX);
        }
        else {
            if (velocity.x<6) {
                velocity.add(velX.mult(-1));
                if (velocity.x>6) { velocity.x = 6; }
            }
            position.add(velX.mult(-1));
        }
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
