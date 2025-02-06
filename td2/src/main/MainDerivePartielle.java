package main;

import affichage.Affichage;
import encadrement.DescenteGradient;
import encadrement.Encadrement;
import encadrement.EncadrerDerivee;
import fonction.Fonction1D;
import fonction.utile.Derivee;
import fonction.utile.Tangeante;
import tp4.FonctionCoupeX;
import tp4.FonctionCoupeY;
import tp4.FonctionD;
import tp4.Himmelblau;

import java.awt.*;

import static fonction.utile.Derivee.DX;
import static tp4.Himmelblau.EPSILON;

public class MainDerivePartielle {
    public static void main(String[] args){

        //fonction
        Himmelblau himmelblau = new Himmelblau();

        //point de depart
        double x0 = 1.0;
        double y0 = 2.0;
        double[] pointDepart = {x0, y0};

        double[] tabDx = {x0+EPSILON, y0};
        double deriveePX = (himmelblau.getValeur(tabDx) - himmelblau.getValeur(pointDepart))/EPSILON;


        double[] tabDy = {x0, y0+EPSILON};
        double deriveePY = (himmelblau.getValeur(tabDy) - himmelblau.getValeur(pointDepart))/EPSILON;

        System.out.println(deriveePX + "\n"+deriveePY);

        //Appel de coupeX et coupeY pour affichage

        FonctionCoupeX fcx = new FonctionCoupeX(himmelblau, pointDepart[0]);
        FonctionCoupeY fcy = new FonctionCoupeY(himmelblau, pointDepart[1]);

        //Appel de la tangeante pour affichage
        Tangeante t = new Tangeante(fcx, pointDepart[0]);

        Affichage a = new Affichage(1000, 600, "Fonction Coupe X");
        a.setXMinMax(-6,6);
        a.setYMinMax(fcx);

        a.afficher(fcx, Color.red);

        a.dessinerPoint(pointDepart[0], t.getF(pointDepart[0]));
        a.afficher(t, Color.blue);

        DescenteGradient dg = new DescenteGradient(fcx, 0.01);
        double x = dg.encadrer(DX, 1);
        a.dessinerPoint(x, fcx.getF(x));

        System.out.println("Point x: "+x+" "+ fcx.getF(x));

        a.rendreEcran();


        Affichage a2 = new Affichage(1000, 600, "Fonciton Coupe Y");
        a2.setXMinMax(-6,6);
        a2.setYMinMax(fcy);

        a2.afficher(fcy, Color.blue);

        DescenteGradient dg2 = new DescenteGradient(fcy, 0.01);
        double y = dg2.encadrer(DX, 2);
        a2.dessinerPoint(y, fcy.getF(y));

        System.out.println("Point y: "+y+" "+ fcx.getF(y));

        a2.rendreEcran();

        /*
        //Derivee partielle dimension N
        double[] tab0..
        double[] tabE = copie(tab0);
        tabE[N] += EPSILON;
        double deriveeP = (himmelblau.getvaleur(tab1) - himmelblau.getValeur(tab0))/EPSILON;

        double[] tab0 = {x0, y0};
        double[] tabE = copie(tab0);
        tabE[0] += EPSILON;
        double derivee = (f.getValeur(tab1) - f.getValeur(tab0))/EPSILON;
        */

    }
}
