
import processing.core.PApplet;
import processing.core.PVector;


public class Earth {
    private int pixelSize = 10;
    private EarthPixel[][] pixels;
    private float yOffset;

    public Earth(int minY, int maxY, App app) {
        yOffset = minY;

        pixels = new EarthPixel[(maxY-minY)/pixelSize][app.width/pixelSize];
        for (int x = 0; x < pixels[0].length; x++) {
            pixels[0][x] = new EarthPixel(app.color(132,160,88));
        }
        for (int y = 1; y < pixels.length; y++) {
            for (int x = 0; x < pixels[0].length; x++) {
                pixels[y][x] = new EarthPixel(app.color(100, 69, 58));
            }
        }
    }

    public void update(App app) {
        Asteroid asrd = app.getAsteroid();
        if (asteroidIsColliding(asrd)) explode(asrd, app);
    }

    public void draw(PApplet app) {
        app.loadPixels();
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[0].length; x++) {
                pixels[y][x].draw(x*pixelSize, y*pixelSize + (int)yOffset, app);
            }
        }
    }

    private int maxY() { return (int) yOffset + pixels.length*pixelSize; }

    private boolean asteroidIsColliding(Asteroid asteroid) {
        if (!(asteroid.getY() < maxY() && asteroid.getY() > yOffset)) return false;
        return !getPixel(asteroid.getX(), asteroid.getY()-yOffset).destroyed;
    }

    private EarthPixel getPixel(float x, float y) {
        return pixels[(int)(y/pixelSize)][(int)(x/pixelSize)];
    }

    private void explode(Asteroid asteroid, App app){

        PVector velocity = asteroid.getVelocity();

        if(velocity.mag() < 1) asteroid.reset(app);

        if(asteroidIsColliding(asteroid)){
            float velX = velocity.x;
            float ratio = velX/velocity.mag();

            float destructionSize = velocity.mag()*2;
            int startDestruction = (int) (asteroid.getX()/pixelSize - destructionSize/2 + ratio*destructionSize/2);


            for(int x = Math.max(startDestruction, 0); x < startDestruction+destructionSize && x< pixels[0].length && x >= 0; x++){
                getPixel(x*pixelSize, asteroid.getY()-yOffset).destroyed = true;
            }
            for(int x = Math.max(startDestruction+1, 0); x < startDestruction+destructionSize && x< pixels[0].length && x >= 0; x++){
                getPixel(x*pixelSize, asteroid.getY()-yOffset-pixelSize).destroyed = true;
            }

            velocity.mult(0.75f);

        }

    }

    /**
     * Private inner class Earth Pixel to draw every pixel of the earth
     * author is BJ <3
     * */

    private class EarthPixel {
        private boolean destroyed = false;
        private int color;
        private EarthPixel(int color) {
            this.color = color;
        }

        private void draw(int x, int y, PApplet app) {
            app.noStroke();
            if(!destroyed) app.fill(this.color);
            else app.fill(app.color(50, 35, 29)); //hole

            app.rect(x, y, pixelSize, pixelSize);
        }
    }
}
