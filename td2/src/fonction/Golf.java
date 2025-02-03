package fonction;

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

        //on donne la distance et la fonction trouve la vitesse

        double distanceParcourue = 0.0;
        while (vitesse > 0.1) { // Tant que la vitesse est supérieure à 0.1
            distanceParcourue += vitesse; // Ajouter la distance parcourue
            vitesse *= 0.9; // Réduire la vitesse de 10% à chaque étape
        }

        return Math.abs(distanceParcourue - distanceCible);
        //return distanceParcourue;
    }
}
