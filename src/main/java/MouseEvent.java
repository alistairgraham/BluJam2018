/**
 * Created by sam on 21/04/18.
 */

public class MouseEvent {
    public enum Type {
        PRESS, RELEASE, MOVE
    }
    public final App game;
    public final Type type;
    public final int x;
    public final int y;

    public MouseEvent(App game, int x, int y, Type type) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x: ");sb.append(x);
        sb.append(" y: ");sb.append(y);
        sb.append(" type: ");sb.append(type.toString());
        return sb.toString();
    }
}
