package GUI;


import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TexturaBetolto extends JPanel{
    private BufferedImage mezok = null;

    public TexturaBetolto() {
        try {
            mezok = ImageIO.read(new File("C:\\Users\\Klentry\\IdeaProjects\\TheExpedition\\src\\pics\\png\\mezok.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    



    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mezok, 330, 264, this);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
