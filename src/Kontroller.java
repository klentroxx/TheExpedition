import terkep.Terkep;
import karakterek.Felfedezo;


import java.util.Scanner;

class Kontroller{
    void start(){
        Terkep terkep = new Terkep();
        Felfedezo jatekos = new Felfedezo("", 100, 100, 250, 0, 3);
        Scanner sc = new Scanner(System.in);

        terkep.letrehoz();
        terkep.kirajzol(jatekos);
        String billentyu;
        while (jatekos.getEletero() != 0 && jatekos.getEnergia() != 0) {
            billentyu = sc.next();
            terkep.billentyuk(jatekos, billentyu);
            terkep.kirajzol(jatekos);
        }
        System.out.println(jatekos.getEletero() == 0 ? "Meghaltál" : "Elfogyott az energiád");
    }
}
