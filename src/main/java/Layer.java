/**
 * Created by sam on 20/04/18.
 */
public abstract class Layer implements GameObject{
    public abstract void draw();
    public abstract void update();

    public boolean contains(Asteroid a){

        return false;
    }


}
