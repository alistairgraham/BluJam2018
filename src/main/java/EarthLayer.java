

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

    }

    @Override
    public void update(Asteroid a) {
        boolean inABoi = false;
        for(int i=0; i<circleBois.size(); i++) {
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
