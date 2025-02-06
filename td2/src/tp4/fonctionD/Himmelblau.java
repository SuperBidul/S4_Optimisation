package tp4.fonctionD;

public class Himmelblau extends FonctionD {

    public static final double EPSILON = 0.01;

    public Himmelblau(){
        super.nbDim = 2;
    }

    @Override
    public double getValeur(double[] x) {
        return Math.pow(x[0]*x[0]+x[1]-11, 2)+Math.pow(x[0]+x[1]*x[1]-7, 2);
    }
}
