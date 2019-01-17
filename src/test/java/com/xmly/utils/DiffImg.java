package com.xmly.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/17
 * Time: 22:50
 */

public class DiffImg {

    public static boolean sameAs(BufferedImage myImage, BufferedImage otherImage, double percent) {
//        BufferedImage otherImage = other.getBufferedImage();
//        BufferedImage myImage = getBufferedImage();
        if (otherImage.getWidth() != myImage.getWidth()) {
            return false;
        }
        if (otherImage.getHeight() != myImage.getHeight()) {
            return false;
        }
        int[] otherPixel = new int[1];
        int[] myPixel = new int[1];
        int width = myImage.getWidth();
        int height = myImage.getHeight();
        int numDiffPixels = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (myImage.getRGB(x, y) != otherImage.getRGB(x, y)) {
                    numDiffPixels++;
                }
            }
        }
        double numberPixels = height * width;
        double diffPercent = numDiffPixels / numberPixels;
        return percent <= 1.0D - diffPercent;
    }

    public static BufferedImage getSubImage(BufferedImage image, int x, int y, int w, int h) {
        return image.getSubimage(x, y, w, h);
    }

    public static BufferedImage getImageFromFile(File f) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return img;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage a = ImageIO.read(new File("/Users/Roger/Desktop/a.jpg"));
        BufferedImage b = ImageIO.read(new File("/Users/Roger/Desktop/b.jpg"));
        BufferedImage c = ImageIO.read(new File("/Users/Roger/Desktop/c.jpg"));

        System.out.println(sameAs(a,c,1));
    }
}
