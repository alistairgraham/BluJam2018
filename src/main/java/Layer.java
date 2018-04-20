/**
 * Created by sam on 20/04/18.
 * Abstract Layer class to create Layer objects
 */
public abstract class Layer implements GameObject{
    private int minY;
    private int maxY;

    public abstract void draw();
    public abstract void update();

    public boolean contains(Asteroid a){
        return a.getY() <= maxY && a.getY() >= minY;
    }


}
