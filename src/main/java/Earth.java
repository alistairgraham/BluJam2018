
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class Earth {
    private EarthPixel[][] pixels;
    private float yOffset;

    public Earth(int minY, int maxY, App app) {
        yOffset = minY;

        pixels = new EarthPixel[maxY-minY][app.width];
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[0].length; x++) {
                pixels[y][x] = new EarthPixel();
            }
        }
    }

    public void update(App app) {
        Asteroid asrd = app.getAsteroid();
        if (asteroidIsColliding(asrd)) explode(asrd);

    }

    public void draw(PApplet app) {
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[0].length; x++) {
                pixels[y][x].draw(x, y + yOffset, app);
            }
        }
    }

    private int maxY() { return (int) yOffset + pixels.length; }

    private boolean asteroidIsColliding(Asteroid asteroid) {
        if (!(asteroid.getY() < maxY() && asteroid.getY() > yOffset)) return false;
        return !getPixel(asteroid.getX(), asteroid.getY()-yOffset).destroyed;
    }

    public void explode(Asteroid asteroid) {
        PVector velocity = asteroid.getVelocity();

        int min = Math.max(0, (int) asteroid.getX() -40);
        int max = Math.min(pixels[0].length, (int) asteroid.getX()+40);

        for (int y = (int)(asteroid.getY()-yOffset); y < pixels.length && y >=0 && y < asteroid.getY() - yOffset + 60; y++) {
            for (float i = min; i < max && i < pixels[0].length; i++) {
                getPixel(i, y).destroyed = true;
            }
        }
        asteroid.reset();
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
        private static PImage green = ImageLoader.getImageAsset("green");
        private EarthPixel() {}

        private void draw(float x, float y, PApplet app) {
            app.noStroke();
            if(!destroyed) {
                //app.fill(app.color(51, 122, 59));
                app.image(green, x, y);
            }
            else {
                //app.fill(117, 117, 117);
                app.image(null, x, y);
            }

            //app.rect(x, y, 1 ,1);
        }
    }
}
