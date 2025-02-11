package tp4.main;

import tp3.encadrement.DescenteGradient;
import tp4.fonction1D.FonctionCoupe;
import tp4.fonctionD.Himmelblau;
import tp4.utile.Gradient;

import static tp4.fonctionD.Himmelblau.EPSILON;

public class MainGradient {
    public static void main (String[] args){

        double[] pointDep = {1.0, 2.0};

        Himmelblau hb = new Himmelblau();

        Gradient g = new Gradient(hb, EPSILON);

        for (int i = 0; i < 10; i++){
            double[] pointDepGrad = g.getGradient(pointDep);
            System.out.println("it "+i+" - x = ("+pointDep[0]+","+pointDep[1]+") - f(x) = "+hb.getValeur(pointDep) + " grad(x) = ("+pointDepGrad[0]+","+pointDepGrad[1]+")");
            pointDep[0] -= EPSILON*pointDepGrad[0];
            pointDep[1] -= EPSILON*pointDepGrad[1];
        }
    }
}
