package tp4.ex2.etudiant;

import tp4.ex1.encadrement.DescenteGradient;

public class Main {
    public static void main(String[] args) {
        //test de l'ensemble et sauvegarde

        // creer un GenerateurCercle autour du cercle de centre (200,200) de rayon 100
        GenerateurCercle generateur = new GenerateurCercle(200,200,100,100);

        // on cree un ProblemeRF de 100 points avec ce generateur
        ProblemeRF pb = new ProblemeRF(100, generateur);

        // on creer un Cercle
        Cercle c = new Cercle(300,100,50);

        // on creer l'image et on ajoute les éléments
        SauveImage image = new SauveImage(500,500);
        image.dessinerCercle(c);
        image.dessinerPoints(pb.points);
        image.sauverImage("test_image.png");

        // optimisation du cercle
        FonctionCercle fc = new FonctionCercle(pb);
        double x = c.getX();
        double y = c.getY();
        double r = c.getRayon();
        double[] cercle = {x, y ,r};

        double perf = fc.getValeur(cercle);
        DescenteGradient dg = new DescenteGradient(fc, 0.01);
        Cercle cercleOpti = new Cercle(dg.optimiser(10000, cercle));

        // on creer l'image et on ajoute les éléments
        image.effacerImage();

        image = new SauveImage(500,500);
        image.dessinerCercle(cercleOpti);
        image.dessinerPoints(pb.points);
        image.sauverImage("test_image2.png");

    }
}
