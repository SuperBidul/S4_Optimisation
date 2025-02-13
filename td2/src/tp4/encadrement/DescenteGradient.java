package tp4.encadrement;

import tp4.fonctionD.FonctionD;
import tp4.utile.Gradient;

import static java.lang.Double.MAX_VALUE;
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

        double[] x_prec = x.clone();  // Sauvegarde du point précédent
        double f_prec = fD.getValeur(x_prec); // Valeur précédente de f(x)

        //Recommencer jusqu'à une condition d’arrêt (nb itération)
        for(int i = 0; i < nbIteration; i++){

            //Déplacer dans la direction opposée au Gradient
            double[] grad = g.getGradient(x);

            // Mise à jour du point x avec le gradient
            for (int j = 0; j < x.length; j++) {
                x[j] -= pas * grad[j];
            }

            double f_nouv = fD.getValeur(x); // Valeur après mise à jour

            // Si on remonte, réduire le pas et revenir en arrière
            if (f_nouv > f_prec){
                pas /= 2;
                x = x_prec.clone();
            }

            // Affichage des résultats
            System.out.printf("it %d - x = (%.5f, %.5f) - f(x) = %.5f - grad(x) = (%.5f, %.5f)\n", i, x[0], x[1], fD.getValeur(x), grad[0], grad[1]);

        }
        //retourne un tableau
        return x;
    }
}
