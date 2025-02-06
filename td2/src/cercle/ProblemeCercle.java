package cercle;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class ProblemeCercle {
    List<Point2D> point2DS;

    public ProblemeCercle(List<Point2D> point2DS) {
        this.point2DS = point2DS;
    }

    // La méthode calcule l'erreur entre le cercle et les points
    public double performance(double x, double y, double r) {
        double perf = 0;

        for (Point2D point : point2DS) {
            double distance = Math.sqrt(Math.pow(x - point.getX(), 2) + Math.pow(y - point.getY(), 2));
            perf += Math.pow(distance - r, 2);
        }

        return perf;
    }

    /*// Initialisation avec le premier point de la liste
        double moyenneX = point2DS.getFirst().getX();
        double moyenneY = point2DS.getFirst().getY();

        // Parcours de la liste à partir du deuxième élément
        for (int i = 1; i < point2DS.size(); i++) {
            Point2D point = point2DS.get(i);
            moyenneX += point.getX();
            moyenneY += point.getY();
        }

        moyenneX /= point2DS.size();
        moyenneY /= point2DS.size();

        x -= moyenneX;
        y -= moyenneY;*/
}
