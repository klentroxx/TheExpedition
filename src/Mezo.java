public class Mezo {
    /** Mezők tulajdonságai */
    private String mezoTipus;
    private boolean ittvagyunke = false;
    private boolean lathatoe = false;

    /** Konstruktorok */
    public Mezo(String mezoTipus) {
        this.mezoTipus = mezoTipus;
    }

    public Mezo() {
    }
    public Mezo(Mezo mezo) {
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

    public String toString(String s) {
        return s;
    }


    /** Mező típusok */




}
