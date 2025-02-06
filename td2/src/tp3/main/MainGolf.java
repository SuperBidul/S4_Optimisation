package tp3.main;

import tp3.affichage.Affichage;
import tp3.encadrement.DescenteGradient;
import tp3.fonction.utile.Derivee;
import tp3.fonction.tp3_.Golf;

import java.awt.*;

import static tp3.fonction.utile.Derivee.DX;

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
        double vitesseOptimale = dg.encadrer(DX, DescenteGradient.POINT_DEPART);

        System.out.println("\nVitesse optimale trouvée : " + vitesseOptimale);
        System.out.printf("\nEquart obtenu avec cette vitesse : %2.6f", g.getF(vitesseOptimale));

        System.out.printf("\n%2.6f",g.getF(19));

        a.rendreEcran();
    }
}
