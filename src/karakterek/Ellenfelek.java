package karakterek;

import java.util.Random;
/** Ellenfelek class. Ez definialja azokat az ellenfeleket, akik statisztikaban megjelennek a kuldetes vegen.*/
public class Ellenfelek {
    private Random r = new Random();
    private int rand = r.nextInt(1200) + 1;
    private String ellenfelnev;
    private int ellenfelhirnev;

    public Ellenfelek() {
    }

    private Ellenfelek(String ellenfelnev, int ellenfelhirnev) {
        this.ellenfelnev = ellenfelnev;
        this.ellenfelhirnev = ellenfelhirnev;
    }

    public void ellenfelstat(Felfedezo felfedezo){
        Ellenfelek jani = new Ellenfelek("Jani", rand);
        System.out.println(jani.ellenfelnev + ": " + jani.ellenfelhirnev + " hirnev");
        if (felfedezo.getHirnev() > jani.ellenfelhirnev){
            System.out.println("Te vagy a legjobb felfedezo!");
        } else {
            System.out.println("Te vagy a masodik legjobb felfedezo!");
        }
    }
}
