package targyak;

public class  Targy {
    private String nev;
    private double energia;
    private boolean fuggoseg;
    private int ar;
    private int hirnev;
    private int maxstack;

    public Targy(String nev, double energia, boolean fuggoseg, int ar, int hirnev, int maxstack) {
        this.nev = nev;
        this.energia = energia;
        this.fuggoseg = fuggoseg;
        this.ar = ar;
        this.hirnev = hirnev;
        this.maxstack = maxstack;
    }

    public Targy(Targy targy){
        this.nev = targy.nev;
        this.energia = targy.energia;
        this.fuggoseg = targy.fuggoseg;
        this.ar = targy.ar;
        this.hirnev = targy.hirnev;
        this.maxstack = targy.maxstack;
    }


    //Gyumolcs, Hus, Csokolade, Kabitoszer, Whiskey, Kotel, Bozotvago, Faklya, Uveggolyo



}
