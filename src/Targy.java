public class  Targy {
    private String nev;
    private double energia;
    private boolean fuggoseg;
    private int ar;
    private int hirnev;
    private int maxstack;

    public Targy(String nev, int maxstack){
        this.nev = nev;
        this.maxstack = maxstack;
    }

    public Targy(String nev, int hirnev, int maxstack){
        this.nev = nev;
        this.hirnev = hirnev;
        this.maxstack = maxstack;
    }

    public Targy(String nev, double energia, boolean fuggoseg, int maxstack) {
        this.nev = nev;
        this.energia = energia;
        this.fuggoseg = fuggoseg;
        this.maxstack = maxstack;
    }

    Targy whiskey = new Targy("Whiskey", 20, true, 7);
    Targy hus = new Targy("Hus", 25, false, 7);
    Targy csokolade = new Targy("Csokolade", 20, false, 7);
    Targy kabitoszer = new Targy("Kabitoszer" , 20, true, 7);
    Targy gyumolcs = new Targy("Gyumolcs", 15, false, 7);
    Targy faklya = new Targy("Faklya", 7);
    Targy kotel = new Targy("Kotel", 7);
    Targy bozotvago = new Targy("Bozotvago", 7);
    Targy uveggolyo = new Targy("Uveggolyo", 7);
    Targy kincs = new Targy("Kincs", 200, 1);
    //Gyumolcs, Hus, Csokolade, Kabitoszer, Whiskey, Kotel, Bozotvago, Faklya, Uveggolyo
    public void whiskey(Felfedezo felfedezo){
        for (int i = 0; i < felfedezo.getCsapattars().length; ++i){
            if (felfedezo.getCsapattars()[i].equals("Katona")){
                felfedezo.setEnergia(felfedezo.getEnergia() + (whiskey.energia * 1.2));
            } else {
                felfedezo.setEnergia(felfedezo.getEnergia() + whiskey.energia);
            }
        }
    }
    public void kabitoszer(Felfedezo felfedezo){
        for (int i = 0; i < felfedezo.getCsapattars().length; ++i){
            if (felfedezo.getCsapattars()[i].equals("Saman")){
                felfedezo.setEnergia(felfedezo.getEnergia() + (kabitoszer.energia * 1.2));
            } else {
                felfedezo.setEnergia(felfedezo.getEnergia() + kabitoszer.energia);
            }
        }
    }
    public void hus(Felfedezo felfedezo){
        felfedezo.setEnergia(felfedezo.getEnergia() + hus.energia);
    }
    public void csokolade(Felfedezo felfedezo){
        felfedezo.setEnergia(felfedezo.getEnergia() + csokolade.energia);
    }
    public void gyumolcs(Felfedezo felfedezo){
        felfedezo.setEnergia(felfedezo.getEnergia() + gyumolcs.energia);
    }
    public void bozotvago(Felfedezo felfedezo, Mezo mezotipus){
        if (felfedezo.getHatizsak().contains(bozotvago) && mezotipus.getMezoTipus().equals("dzsungel")){
            mezotipus.setMezoTipus(" szfold ");
        }
    }


}
