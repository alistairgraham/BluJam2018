import processing.core.PApplet;

import java.util.ArrayList;

/**
 * Created by sam on 20/04/18.
 */
public class EarthLayer extends Layer {
    private ArrayList<CircleBoi> circleBois;

    /**
     * Construct an earth layer
     *
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public EarthLayer(float minY, float maxY) {
        super(minY, maxY);
        circleBois = new ArrayList<CircleBoi>();
    }

    @Override
    public void draw(PApplet pApplet) {
    }

    @Override
    public void modify(Asteroid asteroid) {
        boolean inABoi = false;
        for (CircleBoi c : circleBois) {
//            if (c.contains(a.getX(), a.getY())) {
//                inABoi = true;
//                break;
//            }
        }
        if (inABoi) {
//            a.update(0);
        } else {
            // TODO MUST EXPLODE
//            explode(a);
//            a.reset();

        }
    }
}
