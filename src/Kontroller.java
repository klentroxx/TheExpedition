import java.io.*;

public class Kontroller{
    public void start(){
        Terkep terkep = new Terkep();
        Felfedezo jatekos = new Felfedezo("", 100, 100, 250, 0, 3);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        terkep.letrehoz();
        terkep.kirajzol();
        try {
            String irany;
            while (jatekos.getEletero() != 0 && jatekos.getEnergia() != 0) {
                irany = br.readLine();
                terkep.lepes(jatekos, irany);
                terkep.kirajzol();
                System.out.println("enerjat: " + jatekos.getEnergia());
            }
            System.out.println(jatekos.getEletero() == 0 ? "Meghaltál" : "Elfogyott az energiád");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
