package nl.alexdewaal66.novi.vessels.utils;

import nl.alexdewaal66.novi.vessels.model.DBFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageHelper {

    private static final int MAX_HEIGHT = 50;

    private static BufferedImage bytesToImage(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] imageToBytes(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calcWidth(BufferedImage originalImage) {
        float ratio = (float) originalImage.getHeight() / MAX_HEIGHT;
        return Math.round(originalImage.getWidth() / ratio);
    }

    public static byte[] resizeImage(byte[] imageData, String fileType) {
        BufferedImage originalImage = bytesToImage(imageData);
        int targetWidth = calcWidth(originalImage);
        BufferedImage resizedImage =
                new BufferedImage(targetWidth, MAX_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, MAX_HEIGHT, null);
        graphics2D.dispose();
        return imageToBytes(resizedImage);
    }

}
