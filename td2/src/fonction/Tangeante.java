package fonction;

public class Tangeante implements Fonction1D {

    Fonction1D f1d;
    Fonction1D derivee;
    int x0;

    public Tangeante(Fonction1D f1d, int x0){
        this.f1d = f1d;
        this.derivee = new Derivee(f1d, Derivee.DX);
        this.x0 = x0;
    }

    @Override
    public double getF(double x) {
        return f1d.getF(x0)+derivee.getF(x0)*(x-x0);
    }
}
