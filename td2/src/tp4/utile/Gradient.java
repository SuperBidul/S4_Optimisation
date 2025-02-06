package tp4.utile;

import tp4.fonctionD.FonctionD;

import static tp4.fonctionD.Himmelblau.EPSILON;

public class Gradient {

    FonctionD fd;
    double epsilon;

    public Gradient(FonctionD fd, double epsilon) {
        this.fd = fd;
        this.epsilon = epsilon;
    }

    // retourne la valeur derivee partielle selon la dimension dim de la fonction au point x0
    // x0 represente un vecteur de la dimension de l’espace d’entree de la fonction
    public double getDerivee(int dim, double[] x0){
        //FonctionD a un attribut dimension -> test
        if(dim < 0 || dim >= fd.nbDim){
            throw new IllegalArgumentException("dimension choisie impossible");
        }

        //valeur derivee partielle -> formule cours / mainDeriveePartielle
        double[] xEpsilon = x0.clone();
        xEpsilon[dim] += epsilon;

        // Calculer la dérivée partielle par taux d'accroissement
        double deriveePartielle = (fd.getValeur(xEpsilon) - fd.getValeur(x0)) / epsilon;

        return deriveePartielle;
    }
}
