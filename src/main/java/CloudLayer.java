import processing.core.PApplet;

/**
 * Created by sam on 20/04/18.
 */
public class CloudLayer extends Layer {
    /**
     * Create a CloudLayer
     *
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public CloudLayer(float minY, float maxY) {
        super(minY, maxY);
    }

    @Override
    public void draw(PApplet pApplet) {
    }


    @Override
    public void modify(Asteroid asteroid) {
    }
}
