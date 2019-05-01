package com.valenguard.isplitter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileLoader {

    public void sortImagesFrames() {
        FileHandle directory = Gdx.files.internal("input");
        int i = 0;
        for (FileHandle fileHandle : directory.list()) {
            i++;
            System.out.println(i + ": " + fileHandle.name());

            if (fileHandle.name().endsWith("0.png")) {
                FileHandle directory0 = Gdx.files.internal("input/0/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileHandle.name().endsWith("1.png")) {
                FileHandle directory0 = Gdx.files.internal("input/1/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileHandle.name().endsWith("2.png")) {
                FileHandle directory0 = Gdx.files.internal("input/2/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileHandle.name().endsWith("3.png")) {
                FileHandle directory0 = Gdx.files.internal("input/3/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sortImagesFrameDirections(String folder) {
        FileHandle directory = Gdx.files.internal("input/" + folder);
        int i = 0;
        for (FileHandle fileHandle : directory.list()) {
            i++;
            System.out.println(i + ": " + fileHandle.name());

            if (fileHandle.name().contains("_down")) {
                FileHandle directory0 = Gdx.files.internal("input/" + folder + "/down/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileHandle.name().contains("_left")) {
                FileHandle directory0 = Gdx.files.internal("input/" + folder + "/left/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileHandle.name().contains("_right")) {
                FileHandle directory0 = Gdx.files.internal("input/" + folder + "/right/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileHandle.name().contains("_up")) {
                FileHandle directory0 = Gdx.files.internal("input/" + folder + "/up/" + fileHandle.name());
                File file = fileHandle.file();
                try {
                    Files.move(file.toPath(), directory0.file().toPath(), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<String, Pixmap> loadPixmaps(String folder) {
        FileHandle fileHandle = Gdx.files.internal("input/" + folder);

        Map<String, Pixmap> pixmapMap = new HashMap<String, Pixmap>();

        for (FileHandle file : fileHandle.list()) {
            Pixmap pixmap = new Pixmap(file);
            pixmapMap.put(file.name(), pixmap);
        }

        return pixmapMap;
    }

    public void displayImageNames() {
        FileHandle fileHandle = Gdx.files.internal("input");
        int i = 0;
        for (FileHandle file : fileHandle.list()) {
            i++;
            System.out.println(i + ": " + file.name());
        }
    }

}
