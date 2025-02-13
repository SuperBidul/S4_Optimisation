package tp4.ex1.utile;

import tp4.ex1.fonctionD.FonctionD;

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

    public double[] getGradient(double[] x0){
        //faire le tour de toutes les dimensons -> boucle
        double[] res = new double[x0.length];
        //debut boucle
        for (int i = 0; i < x0.length; i++) {
            //remplis le tableau des valeurs trouvee avec getDerivee
            res[i] = getDerivee(i, x0);
        //fin boucle
        }

        //return tableau remplis
        return res;
    }
}
