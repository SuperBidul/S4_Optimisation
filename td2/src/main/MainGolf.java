package main;

import affichage.Affichage;
import encadrement.DescenteGradient;
import fonction.Derivee;
import fonction.Golf;
import fonction.Tangeante;

import java.awt.*;

import static fonction.Derivee.DX;

public class MainGolf {
    public static void main (String[] args){
        Golf g = new Golf(10);

        Affichage a = new Affichage(1000, 600, "Fonction Golf");
        Derivee derivee = new Derivee(g, Derivee.DX);

        a.setXMinMax(0,2);
        a.setYMinMax(derivee);

        a.afficher(derivee, Color.red);
        a.afficher(g, Color.BLUE);

        // Descente de gradient pour trouver la vitesse optimale
        DescenteGradient dg = new DescenteGradient(g, 0.01);
        double vitesseOptimale = dg.encadrer(0.001, DescenteGradient.POINT_DEPART);

        System.out.println("\nVitesse optimale trouvée : " + vitesseOptimale);
        System.out.printf("\nEquart obtenu avec cette vitesse : %2.6f", g.getF(vitesseOptimale));

        System.out.printf("\n%2.6f",g.getF(19));

        a.rendreEcran();
    }
}
