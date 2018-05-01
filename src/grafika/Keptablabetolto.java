package grafika;

import java.awt.image.BufferedImage;

public class Keptablabetolto {
    BufferedImage keptabla;
    public Keptablabetolto(BufferedImage keptabla){
        this.keptabla = keptabla;
    }

    public BufferedImage kepMezo(int x, int y, int szelesseg, int magassag){
        return keptabla.getSubimage(x, y, szelesseg, magassag);
    }
}
