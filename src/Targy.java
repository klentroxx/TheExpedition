public class  Targy {
    private String nev;
    private double energia;
    private boolean fuggoseg;
    private int ar;
    private int hirnev;

    public Targy(String nev){
        this.nev = nev;
    }

    public Targy(String nev, int hirnev){
        this.nev = nev;
        this.hirnev = hirnev;
    }

    public Targy(String nev, double energia, boolean fuggoseg) {
        this.nev = nev;
        this.energia = energia;
        this.fuggoseg = fuggoseg;
    }

    Targy whiskey = new Targy("Whiskey", 20, true);
    Targy hus = new Targy("Hus", 25, false);
    Targy csokolade = new Targy("Csokolade", 20, false);
    Targy kabitoszer = new Targy("Kabitoszer" , 20, true);
    Targy gyumolcs = new Targy("Gyumolcs", 15, false);
    Targy faklya = new Targy("Faklya");
    Targy kotel = new Targy("Kotel");
    Targy bozotvago = new Targy("Bozotvago");
    Targy uveggolyo = new Targy("Uveggolyo");
    Targy kincs = new Targy("Kincs", 200);
    //Gyumolcs, Hus, Csokolade, Kabitoszer, Whiskey, Kotel, Bozotvago, Faklya, Uveggolyo
    public void whiskey(Felfedezo felfedezo){
        for (int i = 0; i < felfedezo.getSzemelyzet().length; ++i){
            if (felfedezo.getSzemelyzet()[i].equals("Katona")){
                felfedezo.setEnergia(felfedezo.getEnergia() + (whiskey.energia * 1.2));
            } else {
                felfedezo.setEnergia(felfedezo.getEnergia() + whiskey.energia);
            }
        }
    }
    public void kabitoszer(Felfedezo felfedezo){
        for (int i = 0; i < felfedezo.getSzemelyzet().length; ++i){
            if (felfedezo.getSzemelyzet()[i].equals("Saman")){
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
        if (felfedezo.getSlot().contains(bozotvago) && mezotipus.getMezoTipus().equals("dzsungel")){
            mezotipus.setMezoTipus(" szfold ");
        }
    }
    public void faklya(Felfedezo felfedezo, Mezo mezotipus){
        if (felfedezo.getSlot().contains(faklya))
    }

}
