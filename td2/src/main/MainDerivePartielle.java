package main;

import fonction.utile.Derivee;
import tp4.FonctionCoupeX;
import tp4.FonctionCoupeY;
import tp4.Himmelblau;

import static tp4.Himmelblau.EPSILON;

public class MainDerivePartielle {
    public static void main(String[] args){

        //fonction
        Himmelblau himmelblau = new Himmelblau();

        //point de depart
        double[] pointDep = {1.0, 2.0};

        double[] tabDx = {pointDep[0]+EPSILON, pointDep[1]};
        double deriveePX = (himmelblau.getValeur(tabDx) - himmelblau.getValeur(pointDep))/EPSILON;

        double[] tabDy = {pointDep[0], pointDep[1]+EPSILON};
        double deriveePY = (himmelblau.getValeur(tabDy) - himmelblau.getValeur(pointDep))/EPSILON;

        System.out.println(deriveePX + "\n"+deriveePY);


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
