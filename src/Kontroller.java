import grafika.Ablakbetolto;
import karakterek.Ellenfelek;
import terkep.Terkep;
import karakterek.Felfedezo;
import targyak.Hasznal;

import java.awt.*;
import java.util.Scanner;
/** Kontroller class. A program teljes mukodeset ez kontrollalja.*/
class Kontroller{
    void start(){
        Ablakbetolto ablak = new Ablakbetolto("The Expedition", 800, 600);
        int kuldetesek = 5;
        Felfedezo jatekos = new Felfedezo("", 100, 100, 250, 0, 3);
        Ellenfelek ellenfelek = new Ellenfelek();

        while (kuldetesek != 0 && jatekos.getEnergia() > 0 && jatekos.getEletero() > 0){
            Terkep terkep = new Terkep();
            Hasznal hasznal = new Hasznal();
            Scanner sc = new Scanner(System.in);
            hasznal.csapattarsajanl(jatekos);
            String billentyu;
            terkep.letrehoz();
            terkep.kirajzol(jatekos);
            while (!hasznal.kuldetesvege(terkep.getTerkep(), terkep.getIttakarakterY(), terkep.getIttakarakterX()) && jatekos.getEletero() != 0) {
                billentyu = sc.next();
                terkep.billentyuk(jatekos, billentyu);
                terkep.kirajzol(jatekos);
            }
            ellenfelek.ellenfelstat(jatekos);
            kuldetesek--;
        }

    }
}
