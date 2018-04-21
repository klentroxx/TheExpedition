package targyak;

import karakterek.Csapattars;
import java.util.Random;

public class Kereskedes {
    Random r = new Random();
    int rand = r.nextInt(22);
    Targy whiskey = new Targy("Whiskey",        20, true, 20, 0, 7);
    Targy kabitoszer = new Targy("Kabitoszer" , 20, true, 20, 0, 7);
    Targy hus = new Targy("Hus",                25, false, 20, 0, 7);
    Targy csokolade = new Targy("Csokolade",    20, false, 20, 0, 7);
    Targy gyumolcs = new Targy("Gyumolcs",      15, false, 20, 0, 7);
    Targy faklya = new Targy("Faklya",          0, false, 20, 0, 7);
    Targy kotel = new Targy("Kotel",            0, false, 20, 0, 7);
    Targy bozotvago = new Targy("Bozotvago",    0, false, 20, 0, 7);
    Targy uveggolyo = new Targy("Uveggolyo",    0, false, 20, 0, 7);
    Targy kincs = new Targy("Kincs",            0, false, 200, 200, 1);
    Csapattars kereskedo = new Csapattars(  "Kereskedo", false, false);
    Csapattars katona = new Csapattars(     "Katona", false, false);
    Csapattars szamar = new Csapattars(     "Szamar", false,false);
    Csapattars felderito = new Csapattars(  "Felderito", false, false);
    Csapattars saman = new Csapattars(      "Saman", false, false);
    Csapattars bolcs =  new Csapattars(     "Bolcs", false, false);



}
