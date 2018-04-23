package targyak;

import karakterek.Csapattars;
import terkep.Mezo;
import karakterek.Felfedezo;

import java.util.Random;
import java.util.Scanner;
/**Hasznal class. Ez a meg nem valosult targyak hasznalataert lett volna felelos,
 * ennek hianyaban nehany funkcio megvalositasara hivatott.*/
public class Hasznal {
    private Random r = new Random();
    private int rand = r.nextInt(100) + 1;
    private Scanner scanner = new Scanner(System.in);

    public void felderito(Mezo[][] terkep, int ky, int kx){
        for(int i = -2; i <= 2; i++){
            for (int j = -2; j <= 2; j++){
                if(ky + i >= 0 && kx + j >= 0 && ky + i < terkep[0].length && kx + j < terkep.length) {
                    terkep[ky + i][kx + j].setLathatoe(true);
                }
            }
        }
    }
    private void bolcs(Felfedezo felfedezo){
        felfedezo.setViszony(felfedezo.getViszony() + 3);
    }

    public boolean kuldetesvege(Mezo[][] mezo, int ky, int kx){
        if (mezo[ky][kx].getMezoTipus().equals(" aranyp ") || mezo[ky][kx].getMezoTipus().equals("laranyp ")){
            System.out.println("Magtalaltad az Arany Piramist! Folytatod a portyazast? (Y/N)");
            char c = scanner.next().charAt(0);
            return c == 'N';
        }
        return false;
    }
    public void csapattarsajanl(Felfedezo felfedezo){
        Csapattars csapattars = new Csapattars();
        if (rand >= 1 && rand <= 50 && felfedezo.getCsapattars().size() < 4) {
            csapattars.setCsapattarsNev("Felderito");
            csapattars.setSerulte(false);
            csapattars.setFuggoe(false);
        }
        if (rand >= 51 && rand <= 100 && felfedezo.getCsapattars().size() < 4) {
            csapattars.setCsapattarsNev("Bolcs");
            csapattars.setSerulte(false);
            csapattars.setFuggoe(false);
    }
        System.out.println("Csatlakozna hozzad egy felfedezo. 150 aranyba kerul. Elfogadod? (Y / N)");
        Scanner sc = new Scanner(System.in);
        String valasz = sc.next();
        switch (valasz){
            case "Y":
                if (csapattars.getCsapattarsNev().equals("Bolcs")) bolcs(felfedezo);
                felfedezo.getCsapattars().add(csapattars);
                felfedezo.setArany(felfedezo.getArany() - 150);
                System.out.println(csapattars.getCsapattarsNev() + " az uj tarsad.");
                break;
            case "N":
                break;
        }

    }




}
