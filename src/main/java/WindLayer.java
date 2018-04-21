import processing.core.PApplet;

/**
 * Created by sam on 20/04/18.
 */
public class WindLayer extends Layer {
    private float dx;

    /**
     * Default constructor for the Layer
     *
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public WindLayer(float minY, float maxY) {
        super(minY, maxY);
        dx = 2;
    }


    @Override
    public void draw(PApplet pApplet) {

    }

    @Override
    public void modify(Asteroid asteroid) {
        // a.update(dx, 0);
    }
}
