import processing.core.PApplet;
import processing.core.PVector;

import java.util.Arrays;

public class Earth {
    private EarthPixel[][] pixels;

    public Earth(App app) {
        pixels = new EarthPixel[app.height][app.width];
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
                pixels[y][x].draw(x, y, app);
            }
        }
    }

    private boolean asteroidIsColliding(Asteroid asteroid) {
        return getPixel(asteroid.getX(), asteroid.getY()).destroyed;
    }

    private void explode(Asteroid asteroid) {
        PVector velocity = asteroid.getVelocity();
        getPixel(asteroid.getX(), asteroid.getY()).destroyed = true;
    }

    private EarthPixel getPixel(float x, float y) {
        return pixels[(int)y][(int)x];
    }

    private static class EarthPixel {
        private boolean destroyed = false;

        private EarthPixel() {}

        private void draw(float x, float y, PApplet app) {

        }
    }
}
