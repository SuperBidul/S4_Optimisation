package tp4.ex2.etudiant;

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



    }
}
