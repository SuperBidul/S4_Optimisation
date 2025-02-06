package tp3.fonction.tp3_;

import tp3.fonction.Fonction1D;

public class Golf implements Fonction1D {

    private double distanceCible; // Distance cible à atteindre

    public Golf(double distanceCible) {
        this.distanceCible = distanceCible;
    }

    @Override
    public double getF(double vitesse) {

        if (vitesse < 0) {
            throw new IllegalArgumentException("vitesse ne peut pas être negative");
        }

        //on donne la distance et la tp3.fonction trouve la vitesse

        double distanceParcourue = 0.0;
        while (vitesse > 0.1) { // Tant que la vitesse est supérieure à 0.1
            distanceParcourue += vitesse; // Ajouter la distance parcourue
            vitesse *= 0.9; // Réduire la vitesse de 10% à chaque étape
        }

        return Math.pow(distanceParcourue - distanceCible, 2);
        //return distanceParcourue;
    }
}
