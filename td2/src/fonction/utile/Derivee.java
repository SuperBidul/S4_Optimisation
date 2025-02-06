package fonction.utile;

import fonction.Fonction1D;

public class Derivee implements Fonction1D {

    public static final double DX = 0.001;

    Fonction1D aDeriver;
    double dx;

    public Derivee(Fonction1D aD, double dx){
        this.aDeriver = aD;
        this.dx = dx;
    }

    @Override
    public double getF(double x) {
        return (aDeriver.getF(x + dx) - aDeriver.getF(x))/dx;
    }
}
