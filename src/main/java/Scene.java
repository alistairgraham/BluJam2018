import gameObjects.Asteroid;
import gameObjects.layers.*;

import java.util.HashSet;

/**
 * Created by sam on 20/04/18.
 */
public class Scene {
    HashSet<Layer> layers;
    Asteroid asteroid;
    public Scene(){
        asteroid = new Asteroid();
        layers = new HashSet<>();
        layers.add(new SpaceLayer());
        layers.add(new CloudLayer());
        layers.add(new WindLayer());
        layers.add(new EmptyLayer());
        layers.add(new EarthLayer());
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }

    public HashSet<Layer> getLayers(){
        return layers;
    }




}
