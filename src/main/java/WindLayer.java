import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by sam on 20/04/18.
 */
public class WindLayer extends Layer {
    private PVector windVelocity;

    public static final float X_VELOCITY_RANGE = 0.05f;

    /**
     * Create a wind layer
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     * @param windXVelocity The x component of the wind
     * @param windYVelocity The y component of the wind
     */
    public WindLayer(float minY, float maxY, float windXVelocity, float windYVelocity) {
        super(minY, maxY);
        windVelocity = new PVector(windXVelocity, windYVelocity);
    }

    /**
     * Create a wind layer with a random velocity
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public WindLayer(float minY, float maxY) {
        super(minY, maxY);
        double rand = Math.random();
        float windXVel = X_VELOCITY_RANGE * (rand<0.5 ? (float) Math.random() : (float) -Math.random());
        windVelocity = new PVector(windXVel, 0);
    }


    @Override
    public void draw(PApplet pApplet) {
        pApplet.fill(pApplet.color(176,225,242));
        pApplet.rect(0, getMinY(), pApplet.width, getMaxY());
    }

    @Override
    public void modify(Asteroid a) {
        if(contains(a)) a.getVelocity().add(windVelocity); // This will constantly apply wind to the asteroid (accelerating it)
    }
}
