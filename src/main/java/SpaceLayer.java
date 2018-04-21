

/**
 * Created by sam on 20/04/18.
 */
public class SpaceLayer extends Layer {

    int dy;

    public SpaceLayer(){
        this.dy = 2;
    }

    @Override
    public void draw() {

    }

    @Override
    public void update(Asteroid a) {
        a.update(0, dy);
    }
}
