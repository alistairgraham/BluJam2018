

import gameObjects.Asteroid;
import gameObjects.GameObject;

/**
 * Created by sam on 20/04/18.
 * Abstract Layer class to create Layer objects
 */
public abstract class Layer implements Drawable {
    private float minY;
    private float maxY;
    private float minX = 0;
    //private float maxX = screenWidth;
    

    public abstract void update(Asteroid a);

    public boolean contains(Asteroid a){
        return a.getY() <= maxY && a.getY() >= minY;
    }


}
