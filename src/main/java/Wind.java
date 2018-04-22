import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by sam on 22/04/18.
 */
public class Wind extends GameObject{

    private float width;
    private float height;

    public Wind(float xPos, float yPos, float width, float height, float xVelocity) {
        super(xPos, yPos, xVelocity, 0f);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(PApplet pApplet) {
        PImage image = ImageLoader.getImageAsset("wind");
        pApplet.image(image, position.x, position.y, width, height);
    }

    public void update(App app){

        // update wind
        position.add(velocity);
        if (position.x > app.width - 1) position.x = 1;
        if (position.x <= 0) position.x = app.width - 1;
    }

}