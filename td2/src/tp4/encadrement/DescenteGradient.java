package tp4.encadrement;

import tp4.fonctionD.FonctionD;
import tp4.utile.Gradient;

import static tp4.fonctionD.Himmelblau.EPSILON;

public class DescenteGradient {
    FonctionD fD;
    double pas;
    Gradient g;

    public DescenteGradient(FonctionD fD, double pas) {
        this.fD = fD;
        this.pas = pas;
        this.g = new Gradient(this.fD, this.pas);
    }

    public double[] optimiser(int nbIteration, double[] x){

        //Recommencer jusqu'à une condition d’arrêt (nb itération)
        for(int i = 0; i < nbIteration; i++){
            //Déplacer dans la direction opposée au Gradient
            double[] pointDepGrad = g.getGradient(x);
            System.out.printf("it %d - x = (%.5f, %.5f) - f(x) = %.5f - grad(x) = (%.5f, %.5f)\n", i, x[0], x[1], fD.getValeur(x), pointDepGrad[0], pointDepGrad[1]);
            //Estimer le gradient en (x0, y0) (derivées partielles)
            x[0] -= pas*pointDepGrad[0];
            x[1] -= pas*pointDepGrad[1];
        }
        //retourne un tableau
        return x;
    }
}
