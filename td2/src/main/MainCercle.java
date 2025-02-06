package main;

import cercle.ProblemeCercle;
import encadrement.EncadrerDerivee;
import fonction.cercle.FonctionRayon;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MainCercle {
    public static void main(String[] args) {
        // Liste de points
        List<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(0, 100));
        points.add(new Point2D.Double(70, 50));
        points.add(new Point2D.Double(-70, 70));
        points.add(new Point2D.Double(70, -80));
        points.add(new Point2D.Double(-90, -80));
        points.add(new Point2D.Double(-10, -80));

        // Initialisation du problème
        ProblemeCercle pc = new ProblemeCercle(points);

        // Recherche du meilleur rayon pour un cercle centré en (0,0)
        FonctionRayon fr = new FonctionRayon(pc, 0, 0);

        EncadrerDerivee ed = new EncadrerDerivee(fr);
        System.out.printf("\nLe meilleur rayon trouvé est : %2.7f", ed.encadrer(0, 200));
    }
}
