package tp4;

public class Himmelblau extends FonctionD{

    public Himmelblau(){
        super.nbDim = 2;
    }

    @Override
    public double getValeur(double[] x) {
        if(x.length != nbDim){
            throw new IllegalArgumentException("Pas le même nombre de valeur que de dimensions");
        }
        
        return 0;
    }
}
