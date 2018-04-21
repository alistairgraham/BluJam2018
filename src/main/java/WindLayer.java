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
        windVelocity = new PVector(windXVelocity, windYVelocity);
    }


    @Override
    public void draw(PApplet pApplet) {

    }

    @Override
    public void modify(Asteroid asteroid) {
        asteroid.getVelocity().add(windVelocity); // This will constantly apply wind to the asteroid (accelerating it)
    }
}
