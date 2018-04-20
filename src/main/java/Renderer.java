import processing.core.PApplet;

public abstract class Renderer extends PApplet{

    /**
     * Render a given scene
     * @param scene The scene to render
     */
    abstract void render(Scene scene);
}
