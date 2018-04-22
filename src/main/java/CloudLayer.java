import processing.core.PApplet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sam on 20/04/18.
 */
public class CloudLayer extends Layer {
    private Set<Cloud> clouds;

    /**
     * Create a CloudLayer
     *
     * @param minY The min Y value of the layer
     * @param maxY The max Y value of the layer
     */
    public CloudLayer(float minY, float maxY) {
        super(minY, maxY);
        clouds = new HashSet<>();
        Cloud c1 = new Cloud(0, minY + (maxY-minY)/5, 100f, 50f, 3f);
        Cloud c2 = new Cloud(100, minY + (maxY-minY)/4, 100f, 50f, 2f);
        Cloud c3 = new Cloud(150, minY + (3*(maxY-minY)/4), 100f, 50f, 2.8f);
        Cloud c4 = new Cloud(120, minY + (2*(maxY-minY)/3), 100f, 50f, 1.5f);
        clouds.add(c1);
        clouds.add(c2);
        clouds.add(c3);
        clouds.add(c4);
    }

    @Override
    public void draw(PApplet pApplet) {
        for (Cloud c : clouds) c.draw(pApplet);
    }

    @Override
    public void modify(App app) {
        for(Cloud c : clouds) c.update(app);
    }
}
