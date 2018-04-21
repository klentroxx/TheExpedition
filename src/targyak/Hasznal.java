package targyak;

import karakterek.Csapattars;
import terkep.Mezo;
import karakterek.Felfedezo;

public class Hasznal {



    public void kereskedo(){

    }
    public void felderito(Mezo[][] terkep, int ky, int kx){
        for(int i = -2; i <= 2; i++){
            for (int j = -2; j <= 2; j++){
                if(ky + i >= 0 && kx + j >= 0 && ky + i < terkep[0].length && kx + j < terkep.length) {
                    terkep[ky + i][kx + j].setLathatoe(true);
                }
            }
        }
    }
    public void bolcs(Felfedezo felfedezo){
        felfedezo.setViszony(felfedezo.getViszony() + 3);
    }


}
