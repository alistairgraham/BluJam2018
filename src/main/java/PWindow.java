import util.Debug;

import java.io.File;

public class PWindow extends Renderer{

    public PWindow(){

    }

    @Override
    public void render(Scene scene) {

    }

    /**
     * Load the assets within the system
     * @param path Path to directory
     */
    private void loadAssets(String path){
        File folder = new File(path);
        File[] folderItems = folder.listFiles();

        for (File folderItem : folderItems) {
            if (folderItem.isFile()) {
                Debug.log("Loaded File: " + folderItem.getName() + " As: " + folderItem.getName().split("\\.")[0]);
                ImageHandler.loadImageAsset(path + "/" + folderItem.getName(), folderItem.getName().split("\\.")[0], this);
            } else if (folderItem.isDirectory()) {
                Debug.log("Directory " + folderItem.getName());
                loadAssets(path + "/" + folderItem.getName());
            }
        }

    }
}
