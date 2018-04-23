package karakterek;
/** Csapattars class. Ez definialja a felfedezonk csapattarsait.*/
public class Csapattars {
    private String csapattarsNev;
    private boolean serulte;
    private boolean fuggoe;

    public Csapattars(){
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

    public void setFuggoe(boolean fuggoe) {
        this.fuggoe = fuggoe;
    }
}
