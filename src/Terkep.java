import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

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
    private Csapattars csapattars = new Csapattars();

    public void setVulkane(boolean vulkane) {
        this.vulkane = vulkane;
    }

    public void setGejzire(boolean gejzire) {
        this.gejzire = gejzire;
    }

    public Terkep() {
    }

    private void intTerkep(int[][] intTerkep){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src\\terkep1.txt"));
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
                if (intTerkep[i][j] == 0){ terkep[i][j] = new Mezo(0, " tenger ");
                } else if (intTerkep[i][j] == 1){ terkep[i][j] = new Mezo(1, "  hegy  ");
                } else if (intTerkep[i][j] == 2){ terkep[i][j] = new Mezo(2, "  lava  ");
                } else if (intTerkep[i][j] == 3){ terkep[i][j] = new Mezo(3, "  lap   ");
                } else if (intTerkep[i][j] == 4){ terkep[i][j] = new Mezo(4, " szfold ");
                } else if (intTerkep[i][j] == 5){ terkep[i][j] = new Mezo(5, "dzsungel");
                } else if (intTerkep[i][j] == 6){ terkep[i][j] = new Mezo(6, "   to   ");
                } else if (intTerkep[i][j] == 7){ terkep[i][j] = new Mezo(7, "hegyisz ");
                } else if (intTerkep[i][j] == 8){ terkep[i][j] = new Mezo(8, "barlang ");
                } else if (intTerkep[i][j] == 9){ terkep[i][j] = new Mezo(9, " bozot  ");
                } else if (intTerkep[i][j] == 10){ terkep[i][j] = new Mezo(10, " lbozot ");
                } else if (intTerkep[i][j] == 11){ terkep[i][j] = new Mezo(11, "  falu  ");
                } else if (intTerkep[i][j] == 12){ terkep[i][j] = new Mezo(12, " lfalu  ");
                } else if (intTerkep[i][j] == 13){ terkep[i][j] = new Mezo(13, " oltar  ");
                } else if (intTerkep[i][j] == 14){ terkep[i][j] = new Mezo(14, " loltar ");
                } else if (intTerkep[i][j] == 15){ terkep[i][j] = new Mezo(15, " aranyp ");
                } else if (intTerkep[i][j] == 16){ terkep[i][j] = new Mezo(16, "laranyp ");
                }
            }
        }
        terkep[ittahajoY][ittahajoX].setIttvagyunke(true);
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

    public void kirajzol(){

        for(int i = 0; i < terkep[0].length; i++){
            for(int j = 0; j < terkep.length; j++){
                System.out.print((terkep[i][j].isLathatoe() ? (terkep[i][j].isIttvagyunke() ? "|" + terkep[i][j].getMezoTipus() + "|" : " " + terkep[i][j].getMezoTipus() + " ") : " " + terkep[i][j].getMezoTipus() + " "));
            }
            System.out.println();
        }

    }

    public void lepes(Felfedezo felfedezo, String irany) {
            switch(irany){
                case "w":
                    if (0 != ittakarakterY) {
                        rand = r.nextInt(100) + 1;
                        mezotpiusok(-1, 0, felfedezo);
                        if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                        if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                        lepesszamlalo++;
                    }
                    break;
                case "a":
                    if (ittakarakterX != 0){
                        rand = r.nextInt(100) + 1;
                        mezotpiusok(0, -1, felfedezo);
                        if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                        if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                        lepesszamlalo++;
                    }
                    break;
                case "s":
                    if(ittakarakterY != terkep[0].length - 1){
                        rand = r.nextInt(100) + 1;
                        mezotpiusok(1, 0, felfedezo);
                        if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                        if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                        lepesszamlalo++;
                    }
                    break;
                case "d":
                    if(ittakarakterX != terkep.length - 1){
                        rand = r.nextInt(100) + 1;
                        mezotpiusok(0, 1, felfedezo);
                        if (gejzire) neverlucky.gejzTerjedes(lepesszamlalo, terkep, this);
                        if (vulkane) neverlucky.lavaTerjedes(lepesszamlalo, terkep, this);
                        lepesszamlalo++;
                    }
                    break;
            }
            for (int a = 0; a < felfedezo.getSzemelyzet().length; ++a){

                    if(felfedezo.getSzemelyzet()[a] != null && felfedezo.getSzemelyzet()[a].equals("Felderito")){
                        csapattars.felderito(terkep, ittakarakterY, ittakarakterX);
                    } else {
                        for(int i = -1; i < 2; i++){
                            for (int j = -1; j < 2; j++){
                                if(ittakarakterY + i >= 0 && ittakarakterX + j >= 0 && ittakarakterY + i < terkep[0].length && ittakarakterX + j < terkep.length) {
                                    terkep[ittakarakterY + i][ittakarakterX + j].setLathatoe(true);
                                }
                            }
                        }
                    }

            }

        System.out.println("HY: " + ittahajoY + " HX: " + ittahajoX + " KY: " + ittakarakterY +
                " KX: " + ittakarakterX + " HStop: " + hajoStop + " HVane: " + hajonVanE +
                " Random: " + rand + " Vulkane: " + vulkane + " Eletero: " + felfedezo.getEletero() + " Energia: " + felfedezo.getEnergia());

    }

    private void mezotpiusok(int ky, int kx, Felfedezo felfedezo){
        String mTip = terkep[ittakarakterY + ky][ittakarakterX + kx].getMezoTipus();
        switch (mTip){
            case " tenger ":
                if(hajonVanE && !hajoStop){
                    ittahajoY += ky;
                    ittakarakterY += ky;
                    ittahajoX += kx;
                    ittakarakterX += kx;
                    terkep[ittakarakterY][ittakarakterX].setIttvagyunke(true);
                    terkep[ittakarakterY - ky][ittakarakterX - kx].setIttvagyunke(false);
                } else if(hajoStop && terkep[ittakarakterY + ky][ittakarakterX + kx] == terkep[ittahajoY][ittahajoX]){
                    ittakarakterY += ky;
                    ittakarakterX += kx;
                    hajonVanE = true;
                    terkep[ittakarakterY][ittakarakterX].setIttvagyunke(true);
                    terkep[ittakarakterY - ky][ittakarakterX - kx].setIttvagyunke(false);
                    felfedezo.setEnergia(100);
                    felfedezo.setEletero(100);
                }
                break;
            case "  hegy  ":
                break;
            case "  lava  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    felfedezo.setEletero(felfedezo.getEletero() - 30);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    felfedezo.setEletero(felfedezo.getEletero() - 30);
                }
                break;
            case "  lap   ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                }
                break;
            case " szfold ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                }
                break;
            case "dzsungel":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 2);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 2);
                }
                break;
            case "   to   ":
                break;
            case "hegyisz ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    if (rand >= 1 && rand <= 20) neverlucky.atok(terkep, ittakarakterY, ittakarakterX, lepesszamlalo, this);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    if (rand >= 1 && rand <= 20) neverlucky.atok(terkep, ittakarakterY, ittakarakterX, lepesszamlalo, this);
                }
                break;
            case "barlang ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                }
                break;
            case " bozot  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.4);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.4);
                }
                break;
            case " lbozot ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 2.2);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 2.2);
                }
                break;
            case "  falu  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                }
                break;
            case " lfalu  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                }
                break;
            case " oltar  ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                }
                break;
            case " loltar ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                    felfedezo.setViszony(felfedezo.getViszony() - 2);
                }
                break;
            case " aranyp ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                }
                break;
            case "laranyp ":
                if (terkep[ittakarakterY][ittakarakterX] == terkep[ittahajoY][ittahajoX]){
                    lepes1(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                } else {
                    lepes2(ky, kx);
                    felfedezo.setEnergia(felfedezo.getEnergia() - 1.8);
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                }
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

}
