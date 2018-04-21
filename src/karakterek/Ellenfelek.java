package karakterek;

public class Ellenfelek {
    private String ellenfelnev;
    private int ellenfelhirnev;

    public Ellenfelek(String ellenfelnev, int ellenfelhirnev) {
        this.ellenfelnev = ellenfelnev;
        this.ellenfelhirnev = ellenfelhirnev;
    }

    public String getEllenfelnev() {
        return ellenfelnev;
    }

    public void setEllenfelnev(String ellenfelnev) {
        this.ellenfelnev = ellenfelnev;
    }

    public int getEllenfelhirnev() {
        return ellenfelhirnev;
    }

    public void setEllenfelhirnev(int ellenfelhirnev) {
        this.ellenfelhirnev = ellenfelhirnev;
    }
}
