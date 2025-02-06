package tp3.fonction.cercle;

import tp3.cercle.ProblemeCercle;
import tp3.fonction.Fonction1D;

public class FonctionX implements Fonction1D{

    ProblemeCercle pc;
    double y, r;

    public FonctionX(ProblemeCercle pc, double y, double r) {
        this.pc = pc;
        this.y = y;
        this.r = r;
    }

    @Override
    public double getF(double x) {
        return pc.performance(x, y, r);
    }
}