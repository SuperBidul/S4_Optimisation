package main;

import cercle.ProblemeCercle;
import encadrement.Encadrement;
import fonction.cercle.FonctionRayon;
import fonction.cercle.FonctionX;
import fonction.cercle.FonctionY;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MainCercle {
    public static void main(String[] args) {
        // Liste des points donnés
        List<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(0, 100));
        points.add(new Point2D.Double(70, 50));
        points.add(new Point2D.Double(-70, 70));
        points.add(new Point2D.Double(70, -80));
        points.add(new Point2D.Double(-90, -80));
        points.add(new Point2D.Double(-10, -80));

        // Initialisation du problème
        ProblemeCercle pc = new ProblemeCercle(points);

        // Paramètres initiaux
        double x = 0, y = 0, r = 100;
        double PRECISION = 0.001;
        boolean converged = false;
        int iterations = 0;

        Encadrement encadrement;

        while (!converged && iterations < 100) {
            double oldX = x, oldY = y, oldR = r;

            // 1. Trouver le meilleur rayon en fixant (x, y)
            FonctionRayon fr = new FonctionRayon(pc, x, y);
            encadrement = new Encadrement(fr);
            r = encadrement.encadrer(r - 10, r, r + 10);

            // 2. Trouver le meilleur y en fixant (x, r)
            FonctionY fy = new FonctionY(pc, x, r);
            encadrement = new Encadrement(fy);
            y = encadrement.encadrer(y - 10, y, y + 10);

            // 3. Trouver le meilleur x en fixant (y, r)
            FonctionX fx = new FonctionX(pc, y, r);
            encadrement = new Encadrement(fx);
            x = encadrement.encadrer(x - 10, x, x + 10);

            // Vérifier la convergence
            if (Math.abs(oldX - x) < PRECISION && Math.abs(oldY - y) < PRECISION && Math.abs(oldR - r) < PRECISION) {
                converged = true;
            }

            iterations++;
            System.out.printf("Itération %d -> x: %.4f, y: %.4f, r: %.4f\n", iterations, x, y, r);
        }

        System.out.println("Optimisation terminée.");
        System.out.printf("Meilleur cercle trouvé -> x: %.4f, y: %.4f, r: %.4f\n", x, y, r);
    }
}
