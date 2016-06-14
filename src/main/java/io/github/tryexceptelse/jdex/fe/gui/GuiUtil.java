package io.github.tryexceptelse.jdex.fe.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ObjectInput;
import java.lang.reflect.Method;

/**
 * Utility methods that are used in two or more other classes, and so
 * are more conveniently placed in a single third party location then
 * repeated each time they are needed, or placed in an arbitrary file
 */
public class GuiUtil {
    /**
     * Returns ImageView object containing referenced image
     * @param resourceAddress: String of resource path to image within
     *                        graphics folder.
     * @return ImageView containing referenced icon.
     */
    public static ImageView icon(String resourceAddress){
        return new ImageView(iconImage(resourceAddress));
    }

    /**
     * Returns Image object containing referenced image
     * @param path: String of path to image within graphics folder
     * @return Image retrieved from path.
     */
    public static Image iconImage(String path){
        path = "/graphics/" + path;
        return new Image(GuiUtil.class.getResourceAsStream(path));
    }

    /**
     * enumerate function. calls passed function with i, object in iterable.
     * @param iterable: iterable object
     * @param callback: method to be called with i, object
     */
    public static <T> void enumerate(Iterable<T> iterable, Method callback){
        int i = 0;
        for (T item : iterable){
            try {
                callback.invoke(null, i, item);
            } catch (Exception e) {
                return;
            }
            i ++;
        }
    }
}
