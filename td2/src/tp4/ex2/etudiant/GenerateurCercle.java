package tp4.ex2.etudiant;

public class GenerateurCercle implements Generateur {

    /**
     * centre du cercle generateur
     */
    double xCentre, yCentre;

    /**
     * rayon du cercle generateur
     */
    double rayon;

    /**
     * erreur autorisee (ajoute dans x,y)
     */
    double erreur;

    /**
     * generateur de points selon un cercle
     *
     * @param x x du centre du cercle
     * @param y y du centre du cercle
     * @param r rayon du cercle
     * @param bruit bruit ajoute aux points échantillonnes sur le cercle
     */
    public GenerateurCercle(double x,double y,double r, double bruit){
        this.xCentre = x;
        this.yCentre = y;
        this.rayon = r;
        this.erreur = bruit;
    }


    @Override
    public Point2D getPoint() {
        // prend un angle au hasard
        double angle = MonRandom.rand()*Math.PI*2;

        // coordonnees du point
        double px = this.xCentre + this.rayon * Math.cos(angle);
        double py = this.yCentre + this.rayon * Math.sin(angle);

        // ajoute erreur
        px += erreur*(MonRandom.rand()-0.5);
        py += erreur*(MonRandom.rand()-0.5);

        return new Point2D(px,py);
    }
}
