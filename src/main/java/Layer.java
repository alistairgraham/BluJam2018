

/**
 * Created by sam on 20/04/18.
 * Abstract Layer class to create Layer objects
 */
public abstract class Layer implements Drawable {
    private float minY; // Y coordinates increase from the top of the screen to the bottom of the screen
    private float maxY;

    /**
     * Default constructor for the Layer
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public Layer(float minY, float maxY){
        this.minY = minY;
        this.maxY = maxY;
    }

    /**
     * Modify the asteroid by the rules of the given layer.
     * @param app The app
     */
    public abstract void modify(App app);

    public boolean contains(Asteroid asteroid){
        float yPos = asteroid.getY();
        return yPos <= maxY && yPos >= minY;
    }

    public float getMinY() {
        return minY;
    }

    public float getMaxY() {
        return maxY;
    }
}
