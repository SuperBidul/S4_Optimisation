public class Tangeante implements Fonction1D {

    Fonction1D f1d;
    int x0;

    public Tangeante(Fonction1D f1d, int x0){
        this.f1d = new Derivee(f1d, 0.001);
        this.x0 = x0;
    }

    @Override
    public double getF(double x) {
        return f1d.getF(x0)+f1d.getF(x0)*(x-x0);
    }
}
