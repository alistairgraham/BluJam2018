

/**
 * Created by sam on 20/04/18.
 */
public class EarthLayer extends Layer {
    privateArrayList<CircleBoi> circleBois;

    EarthLayer() {
        circleBois = new ArrayList<CircleBoi>();
    }
    @Override
    public void draw() {

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
    }
}
