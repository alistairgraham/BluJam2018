import processing.core.PApplet;
import processing.core.PConstants;

public class ColorCycle {

    private int start;
    private int end;
    private int length;

    public ColorCycle(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public int getColor(int time) {
        float secs = (float) time / 1000f;
        float amt = (secs % (float)length)/ (float) length;
        if (amt < 0.5f) {
            return PApplet.lerpColor(
                    start,
                    end,
                    amt,
                    PConstants.HSB);
        } else {
            return PApplet.lerpColor(
                    end,
                    start,
                    amt,
                    PConstants.HSB);
        }
    }
}
