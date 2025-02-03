package main;

import affichage.Affichage;
import encadrement.DescenteGradient;
import fonction.CosCarre;

import java.awt.*;

import static fonction.Derivee.DX;

public class MainCosCarre {

    public static final int MAXCC = 6;

    public static void main(String[] args) {

        CosCarre cc = new CosCarre();

        Affichage a = new Affichage(1000, 600, "Fct CosCarre");
        a.setXMinMax(0, MAXCC);
        a.setYMinMax(cc);
        a.afficher(cc, Color.BLUE);

        DescenteGradient dg = new DescenteGradient(cc, DescenteGradient.PAS_APPRENTISSAGE);
        double x = dg.encadrer(DX, DescenteGradient.POINT_DEPART);

        a.dessinerPoint(x, cc.getF(x));

        a.rendreEcran();

        System.out.println(x);
        System.out.println(cc.getF(x));
    }
}