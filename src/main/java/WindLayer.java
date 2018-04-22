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
        windVelocity = new PVector(0, 0);
    }


    @Override
    public void draw(PApplet pApplet) {
        drawArrows(pApplet);
    }

    private void drawArrows(PApplet pApplet){

        float layerHeight = getMaxY()-getMinY();

        float yBuffer = 10;
        float xBuffer = 0;
        float xSpacing = 100f;

        float arrowHeight = layerHeight - (2*yBuffer);
        float arrowWidth = Math.min(30f, 500 * Math.abs(windVelocity.x));

        float windStrength = windVelocity.mag();

        boolean isLeft = windVelocity.x > 0f;

        pApplet.stroke(pApplet.color(217, 223, 232));
//        pApplet.stroke(pApplet.color(190, 230, 244));
        pApplet.strokeWeight(25f * windStrength);

        for(int count = 0 ; count <20; count++){
            float startX = isLeft? xBuffer + count*(xSpacing) : pApplet.width - xBuffer - count*(xSpacing) - 18;
            float endX = isLeft? startX + arrowWidth : startX - arrowWidth;
            pApplet.line(startX, getMinY() + yBuffer, endX, getMinY()+ arrowHeight/2 + yBuffer);
            pApplet.line(startX, getMaxY() - yBuffer, endX, getMinY()+ arrowHeight/2 + yBuffer);
        }
    }

    @Override
    public void modify(App app) {
        if (contains(app.getAsteroid())) { //a.getVelocity().add(windVelocity); // This will constantly apply wind to the asteroid (accelerating it)
            app.getAsteroid().affect(windVelocity);
        }

        if (app.millis() % 5 == 0) {
            windVelocity.add((float) ((Math.random() - 0.5) * 0.03), 0f);
        }
    }

}
