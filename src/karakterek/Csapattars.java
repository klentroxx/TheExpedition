package karakterek;

public class Csapattars {
    private String csapattarsNev;
    private boolean serulte;
    private boolean fuggoe;

    public Csapattars(){
    }

    public Csapattars(String csapattarsNev, boolean serulte, boolean fuggoe) {
        this.csapattarsNev = csapattarsNev;
        this.serulte = serulte;
        this.fuggoe = fuggoe;
    }

    public String getCsapattarsNev() {
        return csapattarsNev;
    }

    public void setCsapattarsNev(String csapattarsNev) {
        this.csapattarsNev = csapattarsNev;
    }

    public boolean isSerulte() {
        return serulte;
    }

    public void setSerulte(boolean serulte) {
        this.serulte = serulte;
    }

    public boolean isFuggoe() {
        return fuggoe;
    }

    public void setFuggoe(boolean fuggoe) {
        this.fuggoe = fuggoe;
    }
}
