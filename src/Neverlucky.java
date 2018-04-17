import java.util.Random;

public class Neverlucky {
    private int tmp2, hegyX, hegyY, gejzY, gejzX, lepteto = 1;
    private Mezo[][] segedterkep = new Mezo[7][7];
    private Random r = new Random();
    private int random =r.nextInt(100) + 1;
    public void katasztrofa(Felfedezo felfedezo, Csapattars csapattars, int random) {
        if (random >= 1 && random <= 20) {
            csapattars.setSerulte(true);
            if (csapattars.isSerulte() && random >= 2 && random <= 7) {
                felfedezo.setSzemelyzet(felfedezo.getSzemelyzet());
            }
        } else if (random >= 21 && random <= 30) {

        }

    }

    public void atok(Mezo[][] terkep, int ky, int kx, int lepesszamlalo, Terkep atoke) {
        if (random >= 0 && random <= 0) {
            int yIndex = 0, xIndex = 0;
            int tmp = 1, Ytmp, YtmpAlso = 0, Xtmp, XtmpAlso = 0;
            if (ky + yIndex >= 0 && ky + yIndex < terkep[0].length && kx + xIndex >= 0 && kx + xIndex < terkep.length) {
                while (!terkep[ky + yIndex][kx + xIndex].getMezoTipus().equals("  hegy  ")) {
                    Xtmp = tmp;
                    Ytmp = tmp;
                    yIndex = -tmp;
                    xIndex = -tmp;
                    if (ky + yIndex < 0) YtmpAlso++;
                    if (kx + xIndex < 0) XtmpAlso++;
                    for (yIndex = -tmp + YtmpAlso; yIndex < Ytmp; yIndex++) {
                        if (ky + yIndex >= terkep[0].length - 1) {
                            yIndex--;
                            Ytmp--;
                        }
                        for (xIndex = -tmp + XtmpAlso; xIndex < Xtmp; xIndex++) {
                            if (kx + xIndex >= terkep.length - 1) {
                                xIndex--;
                                Xtmp--;
                            }
                            if (terkep[ky + yIndex][kx + xIndex].getMezoTipus().equals("  hegy  ")) {
                                break;
                            }
                        }
                        if (terkep[ky + yIndex][kx + xIndex].getMezoTipus().equals("  hegy  ")) {
                            break;
                        }
                    }
                    tmp++;
                }
            }
            hegyX = kx + xIndex;
            hegyY = ky + yIndex;
            tmp2 = lepesszamlalo;
            atoke.setVulkane(true);
            lavaTerjedes(lepesszamlalo, terkep, atoke);

        } else if (random >= 1 && random <= 100) {
            int yIndex = 0, xIndex = 0;
            int tmp = 1, Ytmp, YtmpAlso = 0, Xtmp, XtmpAlso = 0;

            if (ky + yIndex >= 0 && ky + yIndex < terkep[0].length && kx + xIndex >= 0 && kx + xIndex < terkep.length) {
                while (!terkep[ky + yIndex][kx + xIndex].getMezoTipus().equals(" szfold ")) {
                    Xtmp = tmp;
                    Ytmp = tmp;
                    yIndex = -tmp;
                    xIndex = -tmp;
                    if (ky + yIndex < 0) YtmpAlso++;
                    if (kx + xIndex < 0) XtmpAlso++;
                    for (yIndex = -tmp + YtmpAlso; yIndex < Ytmp; yIndex++) {
                        if (ky + yIndex >= terkep[0].length - 1) {
                            yIndex--;
                            Ytmp--;
                        }
                        for (xIndex = -tmp + XtmpAlso; xIndex < Xtmp; xIndex++) {
                            if (kx + xIndex >= terkep.length - 1) {
                                xIndex--;
                                Xtmp--;
                            }
                            if (terkep[ky + yIndex][kx + xIndex].getMezoTipus().equals(" szfold ")) break;
                        }
                        if (terkep[ky + yIndex][kx + xIndex].getMezoTipus().equals(" szfold ")) break;
                    }
                    tmp++;
                }
            }
            gejzX = kx + xIndex;
            gejzY = ky + yIndex;
            tmp2 = lepesszamlalo;
            atoke.setGejzire(true);
            gejzTerjedes(lepesszamlalo, terkep, atoke);
        }
    }

    public void lavaTerjedes(int lepesszamlalo, Mezo[][] terkep, Terkep atoke) {
        if (lepesszamlalo == tmp2) {
            System.out.println("Vulkánkitörés!");
            for (int a = -3; a < 4; a++) {
                for (int b = -3; b < 4; b++) {
                    if (hegyY + a >= 0 && hegyY + a < terkep[0].length && hegyX + b >= 0 && hegyX + b < terkep.length) {
                        segedterkep[a + 3][b + 3] = new Mezo(terkep[hegyY + a][hegyX + b]);
                    } else {
                        segedterkep[a + 3][b + 3] = null;
                    }
                }
            }
        }
        if (lepesszamlalo == tmp2 + 1) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (hegyY + i >= 0 && hegyY + i < terkep[0].length && hegyX + j >= 0 && hegyX + j < terkep.length) {
                        if (!terkep[hegyY + i][hegyX + j].getMezoTipus().equals("  hegy  ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("   to   ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("hegyisz ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("barlang ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals(" tenger ")) {
                            terkep[hegyY + i][hegyX + j].setMezoTipus("  lava  ");
                        }
                    }
                }
            }
        }
        if (lepesszamlalo == tmp2 + 2) {
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (hegyY + i >= 0 && hegyY + i < terkep[0].length && hegyX + j >= 0 && hegyX + j < terkep.length) {
                        if (!terkep[hegyY + i][hegyX + j].getMezoTipus().equals("  hegy  ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("   to   ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("hegyisz ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("barlang ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals(" tenger ")) {
                            terkep[hegyY + i][hegyX + j].setMezoTipus("  lava  ");
                        }
                    }
                }
            }
        }
        if (lepesszamlalo == tmp2 + 3) {
            for (int i = -3; i <= 3; i++) {
                for (int j = -3; j <= 3; j++) {
                    if (hegyY + i >= 0 && hegyY + i < terkep[0].length && hegyX + j >= 0 && hegyX + j < terkep.length) {
                        if (!terkep[hegyY + i][hegyX + j].getMezoTipus().equals("  hegy  ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("   to   ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("hegyisz ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals("barlang ") && !terkep[hegyY + i][hegyX + j].getMezoTipus().equals(" tenger ")) {
                            terkep[hegyY + i][hegyX + j].setMezoTipus("  lava  ");
                        }
                    }
                }
            }
        }
        if (lepesszamlalo == tmp2 + 7) {
            for (int i = -3; i < 4; i++) {
                for (int j = -3; j < 4; j++) {
                    if (segedterkep[i + 3][j + 3] != null) {
                        if (segedterkep[i + 3][j + 3].getMezoTipus().equals("dzsungel")) {
                            terkep[hegyY + i][hegyX + j].setMezoTipus(" szfold ");
                        } else if (segedterkep[i + 3][j + 3].getMezoTipus().equals(" bozot  ")) {
                            terkep[hegyY + i][hegyX + j].setMezoTipus(" szfold ");
                        } else if (segedterkep[i + 3][j + 3].getMezoTipus().equals(" lbozot ")) {
                            terkep[hegyY + i][hegyX + j].setMezoTipus("  lap   ");
                        } else {
                            terkep[hegyY + i][hegyX + j] = segedterkep[i + 3][j + 3];
                        }
                    }
                }
            }
            atoke.setVulkane(false);
        }

    }
    public void gejzTerjedes(int lepesszamlalo, Mezo[][] terkep, Terkep atoke){
        if (lepesszamlalo == tmp2) {
            System.out.println("Gejzírkitörés!");
            terkep[gejzY][gejzX].setMezoTipus("  lap   ");
        }
        if (lepesszamlalo == tmp2 + lepteto){
            for (int i = -lepteto; i <= lepteto; ++i){
                for (int j = -lepteto; j <= lepteto; ++j){
                    if (gejzY + i >= 0 && gejzY + i < terkep[0].length && gejzX + j >= 0 && gejzX + j < terkep.length){
                        if (terkep[gejzY + i][gejzX + j].getMezoTipus().equals(" szfold ")) terkep[gejzY + i][gejzX + j].setMezoTipus("  lap   ");
                        if (terkep[gejzY + i][gejzX + j].getMezoTipus().equals("  falu  ")) terkep[gejzY + i][gejzX + j].setMezoTipus(" lfalu  ");
                        if (terkep[gejzY + i][gejzX + j].getMezoTipus().equals(" oltar  ")) terkep[gejzY + i][gejzX + j].setMezoTipus(" loltar ");
                        if (terkep[gejzY + i][gejzX + j].getMezoTipus().equals(" aranyp ")) terkep[gejzY + i][gejzX + j].setMezoTipus("laranyp ");
                        if (terkep[gejzY + i][gejzX + j].getMezoTipus().equals(" bozot  ")) terkep[gejzY + i][gejzX + j].setMezoTipus(" lbozot ");
                    }
                }
            }
            lepteto++;
        }
        if (lepteto == 5){
            atoke.setGejzire(false);
        }
    }


}
