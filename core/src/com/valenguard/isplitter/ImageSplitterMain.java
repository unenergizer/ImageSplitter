package com.valenguard.isplitter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ImageSplitterMain extends ApplicationAdapter {

    private final FileLoader fileLoader = new FileLoader();


    @Getter
    @AllArgsConstructor
    enum FrameValues {
        // LEVEL FEET
        BODY_0_DOWN(0, "down", 6, 3, 2, 1, 1, 0),
        BODY_0_UP(0, "up", 6, 3, 2, 1, 1, 0),
        BODY_2_DOWN(2, "down", 6, 3, 2, 1, 1, 0),
        BODY_2_UP(2, "up", 6, 3, 2, 1, 1, 0),

        BODY_0_LEFT(0, "left", 5, 3, 2, 1, 1, 0),
        BODY_0_RIGHT(0, "right", 5, 3, 2, 1, 1, 0),
        BODY_2_LEFT(2, "left", 5, 3, 2, 1, 1, 0),
        BODY_2_RIGHT(2, "right", 5, 3, 2, 1, 1, 0);

        // TODO: RUNNING FEET

        private int frame;
        private String direction;
        private int chestSize;
        private int chestYup;
        private int pantsSize;
        private int pantsYup;
        private int shoeSize;
        private int shoeYup;
    }

    @Override
    public void create() {

//		// SORTING
//		fileLoader.sortImagesFrames(); // STEP 1
//
//		for (int i = 0; i <= 3; i++) { // STEP 2
//			fileLoader.sortImagesFrameDirections("" + i);
//		}

        for (FrameValues fv : FrameValues.values()) {
            String path = fv.frame + "/" + fv.direction + "/";
            String direction = fv.direction;

            // STEP 3
            split(path, "body_" + direction + "_chest_", direction, fv.chestSize, fv.chestYup);
            split(path, "body_" + direction + "_pants_", direction, fv.pantsSize, fv.pantsYup);
            split(path, "body_" + direction + "_shoes_", direction, fv.shoeSize, fv.shoeYup);
        }
    }

    private void split(String path, String name, String direction, int yHeight, int yUpDistance) {
        for (Map.Entry<String, Pixmap> entrySet : fileLoader.loadPixmaps(path).entrySet()) {

            String todoNameStrip = entrySet.getKey();
            Pixmap pixmap = entrySet.getValue();

            int w = pixmap.getWidth();
            int h = pixmap.getHeight() - yHeight;
            int srcX = 0;
            int srcY = pixmap.getHeight() - yHeight - yUpDistance;

            Pixmap partTexture = new Pixmap(w, yHeight, Pixmap.Format.RGBA8888);
            partTexture.drawPixmap(pixmap, 0, 0, srcX, srcY, w, h);

            // Rename
            todoNameStrip = todoNameStrip.replace("body_" + direction + "_", "");
            PixmapIO.writePNG(new FileHandle("output/" + path + name + todoNameStrip), partTexture);

            partTexture.dispose();
            entrySet.getValue().dispose();
        }
    }

    @Override
    public void render() {
        Gdx.app.exit();
    }

    @Override
    public void dispose() {
    }
}
