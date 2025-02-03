package main;

import affichage.Affichage;
import encadrement.DescenteGradient;
import fonction.Golf;

import java.awt.*;

import static fonction.Derivee.DX;

public class MainGolf {
    public static void main (String[] args){
        Golf g = new Golf(2);


        System.out.printf("\n%2.6f",g.getF(2));

        Affichage a = new Affichage(1000, 600, "Fonction Golf");
        a.setXMinMax(0, 0.6);
        a.setYMinMax(g);
        a.afficher(g, Color.BLUE);

        a.rendreEcran();
    }
}
