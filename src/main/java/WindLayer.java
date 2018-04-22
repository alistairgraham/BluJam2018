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
        windVelocity = new PVector(windXVelocity, 0);
    }


    @Override
    public void draw(PApplet pApplet) {
        pApplet.fill(pApplet.color(176,225,242));
        pApplet.rect(0, getMinY(), pApplet.width, (getMaxY()-getMinY()));


        drawArrows(pApplet);
    }

    private void drawArrows(PApplet pApplet){
        float yBuffer = 50f;
        float xBuffer = 50f;
        float width = 100f;
        float height = getMaxY()-getMinY();
        float windStrength = windVelocity.mag();
        //0.05 -> one
        //0.05 - 0.07 -> two
        //more is 3.
        int numArrows = windStrength>0.07? 3 : windStrength>0.05? 2 : 1;
        boolean isLeft = windVelocity.x > 0f;

        /*
        pApplet.stroke(pApplet.color(0, 0, 0));
        pApplet.strokeWeight(5f);
        pApplet.line(xBuffer, getMinY() + yBuffer, width, getMinY()+ height/2);
        pApplet.line(xBuffer, getMaxY() - yBuffer, width, getMinY()+ height/2);
//        pApplet.line(xBuffer, getMinY() + yBuffer, width, height/2 - yBuffer);
        */
        pApplet.stroke(pApplet.color(0, 0, 0));
        pApplet.strokeWeight(5f);
        for(int count = 0 ; count < numArrows; count++){
            float startX = isLeft? xBuffer + count*(width) : pApplet.width - xBuffer - count*width;
            float endX = isLeft? startX + width : startX - width;
            pApplet.line(startX, getMinY() + yBuffer, endX, getMinY()+ height/2);
            pApplet.line(startX, getMaxY() - yBuffer, endX, getMinY()+ height/2);
        }
    }

    @Override
    public void modify(App app) {
        if (contains(app.getAsteroid())) { //a.getVelocity().add(windVelocity); // This will constantly apply wind to the asteroid (accelerating it)
            app.getAsteroid().affect(windVelocity);
        }
    }

}
