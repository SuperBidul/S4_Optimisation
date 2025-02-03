package main;

import affichage.Affichage;
import fonction.CosCarre;

import java.awt.*;

public class MainCosCarre {

    public static final int MAXCC = 6;

    public static void main(String[] args) {

        CosCarre cc = new CosCarre();

        Affichage a = new Affichage(1000, 600, "Fct CosCarre");
        a.setXMinMax(0, MAXCC);
        a.setYMinMax(cc);
        a.afficher(cc, Color.BLUE);

        a.rendreEcran();
    }
}