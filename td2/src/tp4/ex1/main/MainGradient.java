package tp4.ex1.main;

import tp4.ex1.encadrement.DescenteGradient;
import tp4.ex1.fonctionD.Himmelblau;
import tp4.ex1.utile.Gradient;

import static tp4.ex1.fonctionD.Himmelblau.EPSILON;

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
        System.out.println("it 10 - x = ("+pointDep[0]+","+pointDep[1]+") - f(x) = "+hb.getValeur(pointDep));

        DescenteGradient dG = new DescenteGradient(hb, 0.01);

        double[] pointDep2 = {4, -1};

        System.out.println("\nEssai de la méthode optimiser de DescenteGradient :");
        dG.optimiser(10, pointDep2);

        DescenteGradient dG2 = new DescenteGradient(hb, 0.1);
        pointDep = new double[]{1.0, 2.0};

        System.out.println("\nObserver le comportement de la descente de gradient en utilisant un pas d’apprentissage α de 0.1 :");
        dG2.optimiser(3, pointDep);
    }
}
