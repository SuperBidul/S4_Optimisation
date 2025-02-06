package fonction.cercle;

import cercle.ProblemeCercle;
import fonction.Fonction1D;

public class FonctionRayon implements Fonction1D {

    ProblemeCercle pc;
    double x;
    double y;

    public FonctionRayon(ProblemeCercle pc, double x, double y) {
        this.pc = pc;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getF(double r) {
        return pc.performance(x, y, r);
    }
}
