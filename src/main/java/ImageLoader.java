import processing.core.PApplet;
import processing.core.PImage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex Mitchell on 21/04/2018.
 */
public class ImageLoader {
    private static Map<String, PImage> imageAssets = new HashMap<>();
    private static PImage nullImage = new PImage(10,10);

    /**
     * Load image assets into the ImageLoader.
     * @param filePath The path to the file
     * @param imageName The name to reference the asset as
     * @param renderer The renderer to load the assets through
     */
    public static void loadImageAsset(String filePath, String imageName, PApplet renderer, float width, float height){
        PImage imageAsset = renderer.loadImage(filePath);
        imageAsset.resize((int)width,(int)height);
        imageAssets.put(imageName, imageAsset);
    }

    /**
     * Return an image from a given imageName if it exists, else a null image.
     * @param imageName The image name to try load
     * @return The loaded image
     */
    public static PImage getImageAsset(String imageName){
        return imageAssets.getOrDefault(imageName, nullImage);
    }
}
