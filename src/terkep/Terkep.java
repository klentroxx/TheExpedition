package terkep;

import mentes.Betoltes;
import mentes.Mentes;
import targyak.Hasznal;
import karakterek.Felfedezo;
import targyak.Kincs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/**Terkep class. Rengeteg dologert felelos, itt csinaltam meg a terkep fajlbol valo beolvasasat, a terkep megrajzolasat,
 * a kulonbozo tipusu mezok triggereinek aktivalasat, billentyukombinaciokat, a mezok lathatova tetelet.*/
public class Terkep {
    private int[][] intTerkep = new int[10][10];
    private Mezo[][] terkep = new Mezo[intTerkep[0].length][intTerkep.length];
    private int ittahajoX = 0;
    private int ittahajoY = 0;
    private int ittakarakterX = 0;
    private int ittakarakterY = 0;
    private int lepesszamlalo = 0;
    private boolean hajonVanE;
    private boolean hajoStop;
    private boolean vulkane;
    private boolean gejzire;
    private Random r = new Random();
    private int rand = r.nextInt(100) + 1;
    private Neverlucky neverlucky = new Neverlucky();
    private Hasznal hasznal = new Hasznal();

    public Mezo[][] getTerkep() {
        return terkep;
    }

    public int getIttakarakterX() {
        return ittakarakterX;
    }

    public int getIttakarakterY() {
        return ittakarakterY;
    }

    void setVulkane(boolean vulkane) {
        this.vulkane = vulkane;
    }

    void setGejzire(boolean gejzire) {
        this.gejzire = gejzire;
    }

    public Terkep() {
    }

    private void intTerkep(int[][] intTerkep){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src\\terkep\\terkep1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < intTerkep.length; i++){
            for (int j = 0; j < intTerkep[0].length; j++) {
                if (sc != null) {
                    intTerkep[i][j] = sc.nextInt();
                }
            }
        }
    }

    public void letrehoz(){
        intTerkep(intTerkep);
        for(int i = 0; i < terkep[0].length; i++){
            for(int j = 0; j < terkep.length; j++){
                if (intTerkep[i][j] == 0){ terkep[i][j] = new Mezo(" tenger ");
                } else if (intTerkep[i][j] == 1){ terkep[i][j] = new Mezo("  hegy  ");
                } else if (intTerkep[i][j] == 2){ terkep[i][j] = new Mezo("  lava  ");
                } else if (intTerkep[i][j] == 3){ terkep[i][j] = new Mezo("  lap   ");
                } else if (intTerkep[i][j] == 4){ terkep[i][j] = new Mezo(" szfold ");
                } else if (intTerkep[i][j] == 5){ terkep[i][j] = new Mezo("dzsungel");
                } else if (intTerkep[i][j] == 6){ terkep[i][j] = new Mezo("   to   ");
                } else if (intTerkep[i][j] == 7){ terkep[i][j] = new Mezo("hegyisz ");
                } else if (intTerkep[i][j] == 8){ terkep[i][j] = new Mezo("barlang ");
                } else if (intTerkep[i][j] == 9){ terkep[i][j] = new Mezo(" bozot  ");
                } else if (intTerkep[i][j] == 10){ terkep[i][j] = new Mezo(" lbozot ");
                } else if (intTerkep[i][j] == 11){ terkep[i][j] = new Mezo("  falu  ");
                } else if (intTerkep[i][j] == 12){ terkep[i][j] = new Mezo(" lfalu  ");
                } else if (intTerkep[i][j] == 13){ terkep[i][j] = new Mezo(" oltar  ");
                } else if (intTerkep[i][j] == 14){ terkep[i][j] = new Mezo(" loltar ");
                } else if (intTerkep[i][j] == 15){ terkep[i][j] = new Mezo(" aranyp ");
                } else if (intTerkep[i][j] == 16){ terkep[i][j] = new Mezo("laranyp ");
                }
            }
        }
        terkep[ittahajoY][ittahajoX].setIttvagyunke(true);
        terkep[ittahajoY][ittahajoX].setMezoTipus("  hajo  ");
        hajonVanE = true;
        hajoStop = false;
        for(int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if(ittakarakterY + i >= 0 && ittakarakterX + j >= 0 && ittakarakterY + i < terkep[0].length && ittakarakterX + j < terkep.length) {
                    terkep[ittakarakterY + i][ittakarakterX + j].setLathatoe(true);
                }
            }
        }
    }

    public void kirajzol(Felfedezo felfedezo){
        mezofelfedes(felfedezo);
        for(int i = 0; i < terkep[0].length; i++){
            for(int j = 0; j < terkep.length; j++){
                if (terkep[i][j].isLathatoe()) {
                    if (terkep[i][j].isIttvagyunke()) {
                        System.out.print("|" + terkep[i][j].getMezoTipus() + "|");
                    } else {
                        System.out.print(" " + terkep[i][j].getMezoTipus() + " ");
                    }
                } else {
                    System.out.print("   ????   ");
                }
            }
            System.out.println();
        }
    }

    private void mezofelfedes(Felfedezo felfedezo){
        for (int i = 0; i < felfedezo.getCsapattars().size(); i++)
            if(felfedezo.getCsapattars().get(i).getCsapattarsNev().equals("Felderito")){
                hasznal.felderito(terkep, ittakarakterY, ittakarakterX);
            } else {
                for(int a = -1; a < 2; a++){
                    for (int b = -1; b < 2; b++){
                        if(ittakarakterY + a >= 0 && ittakarakterX + b >= 0 && ittakarakterY + a < terkep[0].length && ittakarakterX + b < terkep.length) {
                            terkep[ittakarakterY + a][ittakarakterX + b].setLathatoe(true);
                        }
                    }
                }
            }

    }

    public void billentyuk(Felfedezo felfedezo, String billentyu) {
        switch(billentyu){
            case "w":
                if (0 != ittakarakterY) {
                    rand = r.nextInt(100) + 1;
                    mezotpiusok(-1, 0, felfedezo);
                    if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                    if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                    for (int i = 0; i < felfedezo.getCsapattars().size(); i++)
                        if (felfedezo.getCsapattars().get(i).isSerulte()) neverlucky.serultTars(felfedezo);
                    lepesszamlalo++;
                }
                break;
            case "a":
                if (ittakarakterX != 0){
                    rand = r.nextInt(100) + 1;
                    mezotpiusok(0, -1, felfedezo);
                    if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                    if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                    for (int i = 0; i < felfedezo.getCsapattars().size(); i++)
                        if (felfedezo.getCsapattars().get(i).isSerulte()) neverlucky.serultTars(felfedezo);
                    lepesszamlalo++;
                }
                break;
            case "s":
                if(ittakarakterY != terkep[0].length - 1){
                    rand = r.nextInt(100) + 1;
                    mezotpiusok(1, 0, felfedezo);
                    if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                    if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                    for (int i = 0; i < felfedezo.getCsapattars().size(); i++)
                        if (felfedezo.getCsapattars().get(i).isSerulte()) neverlucky.serultTars(felfedezo);
                    lepesszamlalo++;
                }
                break;
            case "d":
                if(ittakarakterX != terkep.length - 1){
                    rand = r.nextInt(100) + 1;
                    mezotpiusok(0, 1, felfedezo);
                    if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                    if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                    for (int i = 0; i < felfedezo.getCsapattars().size(); i++)
                        if (felfedezo.getCsapattars().get(i).isSerulte()) neverlucky.serultTars(felfedezo);
                    lepesszamlalo++;
                }
                break;
            case "m":
                new Mentes(felfedezo, this);
                break;
            case "b":
                new Betoltes(felfedezo, this);
                break;
        }
    }

    private void mezotpiusok(int ky, int kx, Felfedezo felfedezo){
        String mTip = terkep[ittakarakterY + ky][ittakarakterX + kx].getMezoTipus();
        double lepeskoltseg = 1;
        switch (mTip){
            case " tenger ":
                if(hajonVanE && !hajoStop){
                    ittahajoY += ky;
                    ittakarakterY += ky;
                    ittahajoX += kx;
                    ittakarakterX += kx;
                    terkep[ittakarakterY][ittakarakterX].setIttvagyunke(true);
                    terkep[ittahajoY][ittahajoX].setMezoTipus("  hajo  ");
                    terkep[ittakarakterY - ky][ittakarakterX - kx].setIttvagyunke(false);
                    terkep[ittahajoY - ky][ittahajoX - kx].setMezoTipus(" tenger ");
                }
                break;
            case "  hegy  ":
                break;
            case "  lava  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.setEletero(felfedezo.getEletero() - 30);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.setEletero(felfedezo.getEletero() - 30);
                }
                break;
            case "  lap   ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                }
                break;
            case " szfold ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                }
                break;
            case "dzsungel":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 2));
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 2));
                }
                break;
            case "   to   ":
                break;
            case "hegyisz ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                    if (rand >= 1 && rand <= 20) neverlucky.atok(terkep, ittakarakterY, ittakarakterX, lepesszamlalo, this);
                    if (rand >= 1 && rand <= 50) neverlucky.katasztrofa(felfedezo);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                    if (rand >= 1 && rand <= 20) neverlucky.atok(terkep, ittakarakterY, ittakarakterX, lepesszamlalo, this);
                    if (rand >= 1 && rand <= 50) neverlucky.katasztrofa(felfedezo);
                }
                break;
            case "barlang ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                    if (rand >= 1 && rand <= 50) neverlucky.katasztrofa(felfedezo);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                    if (rand >= 1 && rand <= 50) neverlucky.katasztrofa(felfedezo);
                }
                break;
            case " bozot  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.4));
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.4));
                }
                break;
            case " lbozot ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 2.2));
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 2.2));
                }
                break;
            case "  falu  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    if (felfedezo.getViszony() >= 2 && rand >= 1 && rand <= 20) hasznal.csapattarsajanl(felfedezo);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    if (felfedezo.getViszony() >= 2 && rand >= 1 && rand <= 20) hasznal.csapattarsajanl(felfedezo);
                }
                break;
            case " lfalu  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                    if (felfedezo.getViszony() >= 2 && rand >= 1 && rand <= 20) hasznal.csapattarsajanl(felfedezo);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                    if (felfedezo.getViszony() >= 2 && rand >= 1 && rand <= 20) hasznal.csapattarsajanl(felfedezo);
                }
                break;
            case " oltar  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                }
                break;
            case " loltar ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                    felfedezo.getKincstar().add(new Kincs(200, 200));
                }
                break;
            case " aranyp ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - lepeskoltseg);
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                }
                break;
            case "laranyp ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - (lepeskoltseg * 1.8));
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                }
                break;
            case "  hajo  ":
                ittakarakterY += ky;
                ittakarakterX += kx;
                hajonVanE = true;
                terkep[ittakarakterY][ittakarakterX].setIttvagyunke(true);
                terkep[ittakarakterY - ky][ittakarakterX - kx].setIttvagyunke(false);
                felfedezo.setEnergia(100);
                felfedezo.setEletero(100);
                break;
            default:
                System.err.println("Nincs ilyen mezo!");
        }

    }
    private void lepes1(int ky, int kx){
        ittakarakterY += ky;
        ittakarakterX += kx;
        hajoStop = true;
        hajonVanE = false;
        terkep[ittakarakterY][ittakarakterX].setIttvagyunke(true);
        terkep[ittakarakterY - ky][ittakarakterX - kx].setIttvagyunke(false);
    }
    private void lepes2(int ky, int kx){
        ittakarakterY += ky;
        ittakarakterX += kx;
        terkep[ittakarakterY][ittakarakterX].setIttvagyunke(true);
        terkep[ittakarakterY - ky][ittakarakterX - kx].setIttvagyunke(false);
    }

    public int getIttahajoX() {
        return ittahajoX;
    }

    public void setIttahajoX(int ittahajoX) {
        this.ittahajoX = ittahajoX;
    }

    public int getIttahajoY() {
        return ittahajoY;
    }

    public void setIttahajoY(int ittahajoY) {
        this.ittahajoY = ittahajoY;
    }

    public void setIttakarakterX(int ittakarakterX) {
        this.ittakarakterX = ittakarakterX;
    }

    public void setIttakarakterY(int ittakarakterY) {
        this.ittakarakterY = ittakarakterY;
    }
}
