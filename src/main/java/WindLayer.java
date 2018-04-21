

/**
 * Created by sam on 20/04/18.
 */
public class WindLayer extends Layer {
	private float dx;
	
	WindLayer() {
        dx = 2; // Right wind
	}

    @Override
    public void draw() {

    }

    @Override
    public void update(Asteroid a) {
	    a.update(dx, 0);
    }
}
