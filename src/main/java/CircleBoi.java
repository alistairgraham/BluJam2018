import processing.core.PApplet;

import java.awt.*;

/**
 * Created by sam on 21/04/18.
 */
public class CircleBoi implements Drawable{
    float diameter;
    Color colour;

    CircleBoi() {
        diameter = 50;
        colour = Color.BLACK;
    }

    boolean contains(float x, float y) {
        //TODO implement this method
        return false;
    }

    @Override
    public void draw(PApplet pApplet) {

    }
}
