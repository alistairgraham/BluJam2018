import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by sam on 20/04/18.
 */
public class WindLayer extends Layer {
    private PVector windVelocity;

    /**
     * Create a wind layer
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     * @param windXVelocity The x component of the wind
     * @param windYVelocity The y component of the wind
     */
    public WindLayer(float minY, float maxY, float windXVelocity, float windYVelocity) {
        super(minY, maxY);
        double rand = Math.random();
        float windXVel = rand<0.5 ? (float) Math.random() : (float) -Math.random();
        rand = Math.random()/2.0;
        float windYVel = rand<0.25 ? (float) Math.random()/2 : (float) -Math.random()/2;
        windVelocity = new PVector(windXVel, windYVel);
    }


    @Override
    public void draw(PApplet pApplet) {
        pApplet.fill(pApplet.color(211,211,211));
        pApplet.rect(0, getMinY(), pApplet.width, getMaxY());
    }

    @Override
    public void modify(Asteroid asteroid) {
        asteroid.getVelocity().add(windVelocity); // This will constantly apply wind to the asteroid (accelerating it)
    }
}
