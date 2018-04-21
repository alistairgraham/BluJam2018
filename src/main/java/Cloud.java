import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by Alex Mitchell on 22/04/2018.
 */
public class Cloud extends GameObject{
    private float width;
    private float height;

    public Cloud(float xPos, float yPos, float width, float height, float xVelocity) {
        super(xPos, yPos, xVelocity, 0f);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(PApplet pApplet) {
        PImage image = ImageLoader.getImageAsset("cloud");
        pApplet.image(image, position.x, position.y, width, height);
    }

    public void update(App app){
        // check asteroid collision
        Asteroid asteroid = app.getAsteroid();
        if (containsAsteroid(asteroid)){
            asteroid.getVelocity().mult(-0.5f);
        }

        // update cloud
        position.add(velocity);
        if(position.x + width < 0) position.x = app.width-1;
        else if(position.x > app.width-1) position.x = 0 - width;
    }

    private boolean containsAsteroid(Asteroid asteroid){
        return asteroid.getX() >= position.x  &&
                asteroid.getX() <= position.x + width &&
                asteroid.getY() >= position.y &&
                asteroid.getY() <= position.y + height;
    }
}
