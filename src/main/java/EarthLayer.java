import java.util.ArrayList;

/**
 * Created by sam on 20/04/18.
 */
public class EarthLayer extends Layer {
    private ArrayList<CircleBoi> circleBois;

    EarthLayer() {
        circleBois = new ArrayList<CircleBoi>();
    }
    @Override
    public void draw() {
        for (CircleBoi c : circleBois) {
            c.draw();
        }
    }

    @Override
    public void update(Asteroid a) {
        boolean inABoi = false;
        for(CircleBoi c : circleBois) {
            if (c.contains(a.getX(), a.getY())) {
                inABoi = true;
                break;
            }
        }
        if (inABoi) {
            a.update(0);
        }
        else {
            // TODO MUST EXPLODE
            explode(a);
            a.reset();

        }
    }


}
