package tp4;

import fonction.Fonction1D;

public class FonctionCoupe implements Fonction1D {

    FonctionD f;
    private int axeCoupe;
    private double[] pointCoupe;

    public FonctionCoupe(FonctionD f, int axeCoupe, double[] pointCoupe) {
        if (pointCoupe.length != f.nbDim) {
            throw new IllegalArgumentException("erreur de dimensions");
        }
        if (axeCoupe < 0 || axeCoupe >= f.nbDim) {
            throw new IllegalArgumentException("L'axe de coupe n'est pas un indice valide pour la fonction.");
        }

        this.f = f;
        this.axeCoupe = axeCoupe;
        this.pointCoupe = pointCoupe.clone();
    }

    @Override
    public double getF(double x) {
        // Créé un tableau pour les coordonnées du point
        double[] point = pointCoupe.clone();

        // Remplace la valeur de l'axe de coupe par la valeur x
        point[axeCoupe] = x;

        // Retourne la valeur de la fonction en ce point
        return f.getValeur(point);
    }
}
