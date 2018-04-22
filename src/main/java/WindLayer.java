import processing.core.PApplet;
import processing.core.PVector;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by sam on 20/04/18.
 */
public class WindLayer extends Layer {
    private PVector windVelocity;

    public static final float MAX_X_VELOCITY = 0.1f;
    public static final float MIN_X_VELOCITY = 0.05f;
    private Set<Wind> wind;

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
        float windXVelocity = (MAX_X_VELOCITY-MIN_X_VELOCITY)*((rand<0.5) ? (float) Math.random(): (float)-Math.random())
                + ((rand<0.5) ? MIN_X_VELOCITY : -MIN_X_VELOCITY);
        windVelocity = new PVector(windXVelocity, 0);


        wind = new HashSet<>();
        Wind w1 = new Wind(0, minY + (maxY-minY)/8, 100f, 50f, windVelocity.x*10);
        Wind w2 = new Wind(200, minY + (maxY-minY)/4, 100f, 50f,  windVelocity.x*10);
        Wind w3 = new Wind(650, minY + (3*(maxY-minY)/4), 100f, 50f, windVelocity.x*10);
        Wind w4 = new Wind(700, minY + (2*(maxY-minY)/3), 100f, 50f,  windVelocity.x*10);
        wind.add(w1);
        wind.add(w2);
        wind.add(w3);
        wind.add(w4);
    }


    @Override
    public void draw(PApplet pApplet) {
        pApplet.fill(pApplet.color(176,225,242));
        pApplet.rect(0, getMinY(), pApplet.width, getMaxY());
        for (Wind w : wind) w.draw(pApplet);
    }

    @Override
    public void modify(App app) {
        if (contains(app.getAsteroid())) { //a.getVelocity().add(windVelocity); // This will constantly apply wind to the asteroid (accelerating it)
            app.getAsteroid().affect(windVelocity);
        }
        for (Wind w : wind) w.update(app);
    }

}
