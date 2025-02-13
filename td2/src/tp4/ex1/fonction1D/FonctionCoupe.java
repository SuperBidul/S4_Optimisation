package tp4.ex1.fonction1D;

import tp3.fonction.Fonction1D;
import tp4.ex1.fonctionD.FonctionD;

public class FonctionCoupe implements Fonction1D {

    FonctionD f;
    private int axeCoupe;
    private double[] pointCoupe;

    public FonctionCoupe(FonctionD f, int axeCoupe, double[] pointCoupe) {
        if (pointCoupe.length != f.nbDim) {
            throw new IllegalArgumentException("erreur de dimensions");
        }
        if (axeCoupe < 0 || axeCoupe >= f.nbDim) {
            throw new IllegalArgumentException("L'axe de coupe n'est pas un indice valide pour la tp3.fonction.");
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

        // Retourne la valeur de la tp3.fonction en ce point
        return f.getValeur(point);
    }
}
