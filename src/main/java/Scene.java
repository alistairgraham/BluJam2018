import java.util.HashSet;

/**
 * Created by sam on 20/04/18.
 */

public class Scene {
    Layer[] layers;
    Asteroid asteroid;
    

    public Scene(){
        asteroid = new Asteroid();
        layers = new Layer[5];
        layers[0] = new SpaceLayer();
        layers[1] = new CloudLayer();
        layers[2] = new WindLayer();
        layers[3] = new EmptyLayer();
        layers[4] = new EarthLayer();
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }

    public Layer[] getLayers(){
        return layers;
    }

    public void update(){
        asteroid.update();
        for(Layer layer : layers) layer.update(asteroid);
	}	}
