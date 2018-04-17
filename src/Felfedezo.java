import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

public class Felfedezo {
    private String nev;
    private int eletero;
    private double energia;
    private int arany;
    private int hirnev;
    private int viszony;
    private Dictionary <Targy, Integer> = new Dictionary <Targy, Integer>
    private Csapattars[] szemelyzet = new Csapattars[3];

    public Felfedezo(String nev, int eletero, double energia, int arany, int hirnev, int viszony) {
        this.eletero = eletero;
        this.nev = nev;
        this.energia = energia;
        this.arany = arany;
        this.hirnev = hirnev;
        this.viszony = viszony;
    }
    public Felfedezo(String[] szemelyzet){
        this.szemelyzet = Arrays.copyOf(szemelyzet, szemelyzet.length);
    }

    public String getNev() {
        return nev;
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

    public int getHirnev() {
        return hirnev;
    }

    public int getViszony() {
        return viszony;
    }

    public ArrayList<Targy> getSlot() {
        return slot;
    }

    public String[] getSzemelyzet() {
        return Arrays.copyOf(szemelyzet, szemelyzet.length);
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setEletero(int eletero) {
        if (eletero > 100) {
            this.eletero = 100;
        } else if (eletero < 0){
            this.eletero = 0;
        } else {
            this.eletero = eletero;
        }
    }

    public void setEnergia(double energia) {
        if (energia > 100) {
            this.energia = 100;
        } else if (energia < 0){
            this.energia = 0;
        } else {
            this.energia = energia;
        }

    }

    public void setArany(int arany) {
        this.arany = arany;
    }

    public void setHirnev(int hirnev) {
        this.hirnev = hirnev;
    }

    public void setViszony(int viszony) {
        this.viszony = viszony;
    }

    public void setSlot(ArrayList<Targy> slot) {
        this.slot = slot;
    }

    public void setSzemelyzet(String[] szemelyzet) {
        this.szemelyzet = szemelyzet;
    }
}
