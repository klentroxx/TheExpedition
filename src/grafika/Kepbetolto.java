package grafika;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Kepbetolto {
    public static BufferedImage kepBetolt(String utvonal){
        try {
            return ImageIO.read(Kepbetolto.class.getResource(utvonal));
        } catch (IOException e) {
            System.err.println("Nem lehet beolvasni a kepet!");
            System.exit(1);
        }
        return null;
    }
}
