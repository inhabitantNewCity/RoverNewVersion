package niit.summer.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageProcessor {

    public Image[][] cutImage(URL file, int rows, int cols) {
        Image[][] images = new Image[rows][cols];
        BufferedImage source = loadImage(file);

        int width = source.getWidth(null);
        int height = source.getHeight(null);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                images[i][j] = new Panel().createImage(new FilteredImageSource(source.getSource(),
                        new CropImageFilter(j * width / cols, i * height / rows,
                                (width / cols), height / rows)));
            }
        }
        return images;
    }

    public BufferedImage loadImage(URL file) {
        BufferedImage source = null;
        try {
            source = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(
                    Level.SEVERE, null, file);
        }
        return source;
    }
}
