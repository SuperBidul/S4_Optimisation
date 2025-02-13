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
        //2 partir de x0, y0

        //Recommencer jusqu'à une condition d’arrêt (nb itération)
        for(int i = 0; i < nbIteration; i++){
            //Déplacer dans la direction opposée au Gradient
            double[] pointDepGrad = g.getGradient(x);
            System.out.println("it "+i+" - x = ("+x[0]+","+x[1]+") - f(x) = "+fD.getValeur(x) + " grad(x) = ("+pointDepGrad[0]+","+pointDepGrad[1]+")");
            //Estimer le gradient en (x0, y0) (derivees partielles)
            x[0] -= EPSILON*pointDepGrad[0];
            x[1] -= EPSILON*pointDepGrad[1];
        }
        //retourne un tableau
        return x;
    }
}
