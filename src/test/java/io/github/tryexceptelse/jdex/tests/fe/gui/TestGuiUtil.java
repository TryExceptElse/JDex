package io.github.tryexceptelse.jdex.tests.fe.gui;

import io.github.tryexceptelse.jdex.fe.gui.GuiUtil;

import com.sun.istack.internal.NotNull;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

/**
 * Tests Gui Utility methods
 */
public class TestGuiUtil extends TestCase {
    /**
     * Tests that iconImage returns image object from correct path
     */
    public void testIconImageReturnsJavaFxImageFromPath() {
        Image returned = GuiUtil.iconImage("mail.png");
        Image target = new Image(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("graphics/test_mail.png"));
        assertImagesEqual(returned, target);
    }

    /**
     * Tests that icon returns ImageView object from correct path
     */
    public void testIconReturnsImageViewFromPath() {
        ImageView returned = GuiUtil.icon("add_contact.png");
        ImageView target = new ImageView(new Image(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("graphics/test_add_contact.png")));
        assertImageViewsEqual(target, returned);
    }

    /**
     * Default Margin of error equality assertion for two images.
     * @param imageA: first Image
     * @param imageB: second Image
     */
    private void assertImagesEqual(Image imageA, Image imageB){
        assertImagesEqual(imageA, imageB, 0.);
    }

    /**
     * defining an image comparison method here for lack of a better idea
     */
    private void assertImagesEqual(@NotNull Image imageA,@NotNull Image imageB,
                                   double moe) {
        if (imageA.getWidth() != imageB.getWidth()) throw new
                AssertionFailedError(
                String.format("Images had different widths: A: %s, B: %s",
                        imageA.getWidth(), imageB.getWidth()));
        if (imageA.getWidth() != imageB.getWidth()) throw new
                AssertionFailedError(
                String.format("Images had different heights: A: %s, B: %s",
                        imageA.getHeight(), imageB.getHeight()));
        class Pair {
            private final double first;
            private final double last;
            private Pair(double first, double last) {
                this.first = first;
                this.last = last;
            }
            private double getFirst() {
                return first;
            }
            private double getLast() {
                return last;
            }
        }
        int width = (int) imageA.getWidth();
        int height = (int) imageA.getHeight();
        int pixels = width * height;
        double cumulativeDifference = 0.;
        // for each column x
        for (int x = 0; x < width; x++) {
            // get pixel at y
            for (int y = 0; y < height; y++) {
                // get corresponding pairs of pixels.
                Color colorA = imageA.getPixelReader().getColor(x, y);
                Color colorB = imageA.getPixelReader().getColor(x, y);
                // make pixel value pairs.
                Pair[] compPairs = new Pair[]{
                        new Pair(colorA.getRed(), colorB.getRed()),
                        new Pair(colorA.getGreen(), colorB.getGreen()),
                        new Pair(colorA.getBlue(), colorB.getBlue()),
                        new Pair(colorA.getOpacity(), colorB.getOpacity()),
                };
                // compare each pair of values. divide by total number of
                // comparisons, and add to cumulative difference.
                for (Pair pair : compPairs){
                    double diff = Math.abs(pair.getFirst() - pair.getLast());
                    cumulativeDifference += diff / (pixels * compPairs.length);
                }
            }
        }
        // throw error if margin of error was exceeded
        if (cumulativeDifference > moe) throw new AssertionFailedError(
                String.format("Image difference exceeded margin of error. \n" +
                        "Difference:         %s\n" +
                        "Margin of Error:    %s",
                cumulativeDifference, moe));
    }

    /** Asserts that two imageViews are equal */
    private void assertImageViewsEqual(ImageView imageViewA,
                                       ImageView imageViewB){
        assertImagesEqual(imageViewA.getImage(), imageViewB.getImage(), 0.);
    }
}
