package tp4.ex2.etudiant;

/**
 * un element pour le reconnaissance de forme
 * - un point2D (x,y)
 */
public class Point2D {

    double x, y;

    /**
     * constructeur de point2d
     *
     * @param x abscisse
     * @param y ordonee
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * retourne distance euclidienne entre deux points
     *
     * @param autre autre point
     * @return distance euclidienne
     */
    public double distance(Point2D autre) {
        double dx = this.x - autre.x;
        double dy = this.y - autre.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
