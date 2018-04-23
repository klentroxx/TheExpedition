package karakterek;

import targyak.Kincs;

import java.util.ArrayList;
/** Felfedezo class. Ez definialja a felfedezonket.*/
public class Felfedezo {
    private String nev;
    private int eletero;
    private double energia;
    private int arany;
    private int hirnev;
    private int viszony;
    private ArrayList<Csapattars> csapattars = new ArrayList<>();
    private ArrayList<Kincs> kincstar = new ArrayList<>();

    public Felfedezo(String nev, int eletero, double energia, int arany, int hirnev, int viszony) {
        this.eletero = eletero;
        this.nev = nev;
        this.energia = energia;
        this.arany = arany;
        this.hirnev = hirnev;
        this.viszony = viszony;
    }


    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEletero() {
        return eletero;
    }

    public double getEnergia() {
        return energia;
    }

    public int getArany() {
        return arany;
    }

    public void setArany(int arany) {
        this.arany = arany;
    }

    public int getHirnev() {
        return hirnev;
    }

    public void setHirnev(int hirnev) {
        this.hirnev = hirnev;
    }

    public int getViszony() {
        return viszony;
    }

    public void setViszony(int viszony) {
        this.viszony = viszony;
    }

    public ArrayList<Csapattars> getCsapattars() {
        return csapattars;
    }

    public ArrayList<Kincs> getKincstar() {
        return kincstar;
    }

    public void setEletero(int eletero) {
        if (eletero > 100) {
            this.eletero = 100;
        } else if (eletero < 0) {
            this.eletero = 0;
        } else {
            this.eletero = eletero;
        }
    }

    public void setEnergia(double energia) {
        if (energia > 100) {
            this.energia = 100;
        } else if (energia < 0) {
            this.energia = 0;
        } else {
            this.energia = energia;
        }

    }

}
