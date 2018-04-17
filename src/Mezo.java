public class Mezo {
    /** Mezők tulajdonságai */
    private int mezoKod;
    private String mezoTipus;
    private boolean ittvagyunke = false;
    private boolean lathatoe = false;

    /** Konstruktorok */
    public Mezo(int mezoKod, String mezoTipus) {
        this.mezoKod = mezoKod;
        this.mezoTipus = mezoTipus;
    }

    public Mezo() {
    }
    public Mezo(Mezo mezo) {
        this.mezoKod = mezo.mezoKod;
        this.mezoTipus = mezo.mezoTipus;
        this.ittvagyunke = false;
        this.lathatoe = mezo.lathatoe;
    }

    /** Getterek */

    public String getMezoTipus() {
        return mezoTipus;
    }

    public boolean isIttvagyunke() {
        return ittvagyunke;
    }

    public boolean isLathatoe() {
        return lathatoe;
    }

    /** Setterek */

    public void setMezoTipus(String mezoTipus) {
        this.mezoTipus = mezoTipus;
    }

    public void setIttvagyunke(boolean ittvagyunke) {
        this.ittvagyunke = ittvagyunke;
    }

    public void setLathatoe(boolean lathatoe) {
        this.lathatoe = lathatoe;
    }


    /** Mező típusok */




}
