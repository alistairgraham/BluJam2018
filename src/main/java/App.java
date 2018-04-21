import processing.core.PApplet;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App extends PApplet{
	private Asteroid asteroid;
	private Layer[] layers;
	private Earth earth;

    public void mousePressed() {
        InputHandler.addEvent(new MouseEvent(this, mouseX, mouseY, MouseEvent.Type.PRESS));
    }

    public void mouseReleased() {
        InputHandler.addEvent(new MouseEvent(this, mouseX, mouseY, MouseEvent.Type.RELEASE));
    }

    public void keyPressed() {
        InputHandler.keyDown.put(keyCode, true);
    }

    public void keyReleased() {
        InputHandler.keyDown.put(keyCode, false);
    }

    public void settings() {
        fullScreen();
    }

    public void setup() {
        ellipse(width/2, height/2, height, height);
        layers = new Layer[4];
        layers[0] = new SpaceLayer(0, height/5);
        layers[1] = new WindLayer(height/5, 2*height/5);
        layers[2] = new CloudLayer(2*height/5, 3*height/5);
        layers[3] = new EmptyLayer(3*height/5, 4*height/5);
        asteroid = new Asteroid();
        earth = new Earth(this);


    }

    public static void main(String[] args) {
        PApplet.main(App.class);
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }

    public Layer[] getLayers() {
        return layers;
    }
}
