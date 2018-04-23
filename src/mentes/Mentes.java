package mentes;

import karakterek.Felfedezo;
import terkep.Terkep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/** Mentes funkcio.*/
public class Mentes {
    private BufferedWriter wr;
    private Felfedezo felfedezo;
    private Terkep terkep;
    public Mentes(Felfedezo felfedezo, Terkep terkep){
        this.felfedezo = felfedezo;
        this.terkep = terkep;
        jatekMentes();
    }

    private void jatekMentes() {
        try{
            wr = new BufferedWriter(new FileWriter("src\\mentes\\data.txt"));
            jatekosMentes();
            wr.close();
            System.out.println("Jatek elmentve.");
        } catch (IOException e){
            System.err.println("Nem lehet beolvasni a fajlt!");
        }
    }

    private void jatekosMentes() {
        try {
            wr.write(String.valueOf(felfedezo.getNev()));
            wr.newLine();
            wr.write(String.valueOf(felfedezo.getEnergia()));
            wr.newLine();
            wr.write(String.valueOf(felfedezo.getEletero()));
            wr.newLine();
            wr.write(String.valueOf(felfedezo.getArany()));
            wr.newLine();
            wr.write(String.valueOf(felfedezo.getViszony()));
            wr.newLine();
            wr.write(String.valueOf(felfedezo.getHirnev()));
            wr.newLine();
            wr.write(String.valueOf(terkep.getIttakarakterX()));
            wr.newLine();
            wr.write(String.valueOf(terkep.getIttakarakterY()));
            wr.newLine();
            wr.write(String.valueOf(terkep.getIttahajoX()));
            wr.newLine();
            wr.write(String.valueOf(terkep.getIttahajoY()));
            wr.newLine();
        } catch (IOException e){
            System.err.println("Nem sikerult menteni.");
        }
    }
}
