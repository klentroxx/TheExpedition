package mentes;

import karakterek.Felfedezo;
import terkep.Terkep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/** Betoltes funkcio.*/
public class Betoltes {
    private Terkep terkep;
    private Felfedezo felfedezo;
    private File file = new File("src\\mentes\\data.txt");
    private Scanner sc;

    public Betoltes(Felfedezo felfedezo, Terkep terkep){
            this.felfedezo = felfedezo;
            this.terkep = terkep;
            beolvas();
    }

    private void beolvas() {
        try {
            sc = new Scanner(file);
            beolvasFelfedezo();
            beolvasTerkep();
        } catch (FileNotFoundException e){
            System.err.println("Nem sikerult betolteni.");
        }
    }

    private void beolvasFelfedezo() {
        felfedezo.setNev(sc.next());
        felfedezo.setEnergia(sc.nextDouble());
        felfedezo.setEletero(sc.nextInt());
        felfedezo.setArany(sc.nextInt());
        felfedezo.setViszony(sc.nextInt());
        felfedezo.setHirnev(sc.nextInt());
    }

    private void beolvasTerkep() {
        terkep.setIttakarakterX(sc.nextInt());
        terkep.setIttakarakterY(sc.nextInt());
        terkep.setIttahajoX(sc.nextInt());
        terkep.setIttahajoY(sc.nextInt());
    }
}
