package fonction.cercle;

import cercle.ProblemeCercle;
import fonction.Fonction1D;

public class FonctionY implements Fonction1D {

    ProblemeCercle pc;
    double x, r;

    public FonctionY(ProblemeCercle pc, double x, double r) {
        this.pc = pc;
        this.x = x;
        this.r = r;
    }

    @Override
    public double getF(double y) {
        return pc.performance(x, y, r);
    }

}
