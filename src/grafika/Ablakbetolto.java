package grafika;

import javax.swing.*;
import java.awt.*;

public class Ablakbetolto {
    JFrame frame;
    Canvas canvas;

    private String ablaknev;
    private int szelesseg, magassag;

    public Ablakbetolto(String ablaknev, int szelesseg, int magassag){
        this.ablaknev = ablaknev;
        this.szelesseg = szelesseg;
        this.magassag = magassag;
        ablakMegjelen();
    }

    private void ablakMegjelen() {
        frame = new JFrame(ablaknev);
        frame.setSize(szelesseg, magassag);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(szelesseg, magassag));
        canvas.setMinimumSize(new Dimension(szelesseg, magassag));
        canvas.setMaximumSize(new Dimension(szelesseg, magassag));

        frame.add(canvas);
        frame.pack();
    }


}
