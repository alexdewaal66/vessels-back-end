package nl.alexdewaal66.novi.vessels.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageHelperTest {

    byte[] loadFileContent(String filename) {
        try {
            Path path = Paths.get("test_data", filename);
            File file = ResourceUtils.getFile("classpath:" + path);
            try (InputStream in = Files.newInputStream(file.toPath())) {
                return in.readAllBytes();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Test
    @DisplayName("resizeImage: resulting image has MAX_HEIGHT height and proportional width")
    void resizeImage_resultingImageHasHeightOf50andProportionalWidth() {
        // arrange
        byte[] fullSizeContent = loadFileContent("test_image_full_size.jpg");
        BufferedImage fullSize = ImageHelper.bytesToImage(fullSizeContent);
        // act
        byte[] thumbnailContent = ImageHelper.resizeImage(fullSizeContent);
        BufferedImage thumbnail = ImageHelper.bytesToImage(thumbnailContent);
        // assert
        assertEquals(thumbnail.getHeight(), ImageHelper.MAX_HEIGHT);
        assertEquals((float) fullSize.getHeight() / fullSize.getWidth(),
                (float) thumbnail.getHeight() / thumbnail.getWidth(),
                1.0/ImageHelper.MAX_HEIGHT);
    }
}
// arrange
// act
// assert
