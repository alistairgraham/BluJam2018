
import processing.core.PApplet;
import processing.core.PVector;

import java.util.Arrays;

public class Earth {
    private EarthPixel[][] pixels;
    private float yOffset = 800;

    public Earth(App app) {
        pixels = new EarthPixel[app.height - (int)yOffset][app.width];
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[0].length; x++) {
                pixels[y][x] = new EarthPixel();
            }
        }
    }

    public void update(App app) {
        Asteroid asrd = app.getAsteroid();
        if (asteroidIsColliding(asrd)) {
            explode(asrd);
        }
    }

    public void draw(PApplet app) {
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[0].length; x++) {
                pixels[y][x].draw(x, y + yOffset, app);
            }
        }
    }

    private boolean asteroidIsColliding(Asteroid asteroid) {
        return !getPixel(asteroid.getX(), asteroid.getY()+yOffset).destroyed;
    }

    private void explode(Asteroid asteroid) {
        PVector velocity = asteroid.getVelocity();
        getPixel(asteroid.getX(), asteroid.getY()).destroyed = true;
        int min = (int) asteroid.getX() -20;
        int max = (int) asteroid.getX()+20;

        for(float i = min; i < max && i < pixels[0].length; i++){
            getPixel(i, asteroid.getY()).destroyed = true;
        }

    }

    private EarthPixel getPixel(float x, float y) {
        return pixels[(int)y][(int)x];
    }


    /**
     * Private inner class Earth Pixel to draw every pixel of the earth
     * author is BJ <3
     * */
    private static class EarthPixel {
        private boolean destroyed = false;

        private EarthPixel() {}

        private void draw(float x, float y, PApplet app) {
            app.noStroke();
            if(!destroyed){
                app.fill(app.color(51, 122, 59));
                app.rect(x, y, 1 ,1);
            }
        }
    }
}
