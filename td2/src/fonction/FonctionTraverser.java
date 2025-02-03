package fonction;

public class FonctionTraverser implements Fonction1D {

    double vEau;
    double vSol;

    public FonctionTraverser(double eau, double sol){
        this.vEau = eau;
        this.vSol = sol;
    }

    @Override
    public double getF(double x) {
        return (1/vEau)*Math.sqrt(Math.pow(500-x, 2)+50*50)+(1/vSol)*Math.sqrt(x*x+450*450);
    }
}
