package tp4.ex2.etudiant;

import java.awt.*;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SauveImage {

    /**
     * taille des points
     */
    public static final int TAILLE_POINTS = 6;


    /**
     * l'image manipulée
     */
    public BufferedImage image;


    public static String REPERTOIRE = "images";

    public SauveImage(int tx, int ty) {
        // creation de l'image
        this.image = new BufferedImage(tx, ty, BufferedImage.TYPE_3BYTE_BGR);

        effacerImage();

    }

    private void effacerImage() {
        // taille du bord
        int decal = 4;

        // creer une image blanche avec bord noir
        Graphics g = this.image.getGraphics();
        int tx = this.image.getWidth();
        int ty= this.image.getHeight();
        g.fillRect(decal, decal, tx - 2 * decal, ty - 2 * decal);
    }

    public void sauverImage(String nom) {
        // si repertoire existe pas
        File f = new File(REPERTOIRE);
        // le creer
        if (!f.exists()) {
            f.mkdir();
        }

        // sauver image
        String name = REPERTOIRE + "/" + nom;

        // si une erreur, stoppe tout.
        try {
            ImageIO.write(image, "PNG", new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * permet de dessiner un cercle dans l'image
     *
     * @param c cercle a dessiner
     */
    public void dessinerCercle(Cercle c) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(3.f));

        double vx = c.getX() - c.getRayon();
        double vy = c.getY() - c.getRayon();
        int width = (int) (c.getRayon() * 2);
        g.drawOval((int) vx, (int) vy, width, width);
        g.dispose();
    }

    /**
     * permet de dessiner une liste de points
     *
     * @param points liste des points à dessiner
     */
    public void dessinerPoints(List<Point2D> points) {
        // creation de l'imaage
        Graphics g = image.getGraphics();
        int width = image.getWidth();


        // dessine les points
        g.setColor(Color.black);
        for (Point2D p : points) {
            int x = (int) p.getX() - TAILLE_POINTS / 2;
            int y = (int) p.getY() - TAILLE_POINTS / 2;
            g.fillOval(x, y, TAILLE_POINTS, TAILLE_POINTS);
        }

        g.dispose();
    }


}
