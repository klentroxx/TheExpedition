package terkep;
/** Mezo class. A mezok definialasara szolgal.*/
public class Mezo {
    private String mezoTipus;
    private boolean ittvagyunke = false;
    private boolean lathatoe = false;

    Mezo(String mezoTipus) {
        this.mezoTipus = mezoTipus;
    }

    Mezo(Mezo mezo) {
        this.mezoTipus = mezo.mezoTipus;
        this.ittvagyunke = false;
        this.lathatoe = mezo.lathatoe;
    }


    public String getMezoTipus() {
        return mezoTipus;
    }

    boolean isIttvagyunke() {
        return ittvagyunke;
    }

    boolean isLathatoe() {
        return lathatoe;
    }

    void setMezoTipus(String mezoTipus) {
        this.mezoTipus = mezoTipus;
    }

    void setIttvagyunke(boolean ittvagyunke) {
        this.ittvagyunke = ittvagyunke;
    }

    public void setLathatoe(boolean lathatoe) {
        this.lathatoe = lathatoe;
    }





}
