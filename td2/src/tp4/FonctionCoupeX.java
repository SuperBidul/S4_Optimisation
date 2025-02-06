package tp4;

import fonction.Fonction1D;

public class FonctionCoupeX implements Fonction1D {

    FonctionD f;
    double y0;

    public FonctionCoupeX(FonctionD f, double y0) {
        if(f.nbDim != 2){
            throw new IllegalArgumentException("erreur de dimensions");
        }

        this.f = f;
        this.y0 = y0;
    }

    @Override
    public double getF(double x) {
        //valeur de la coupe en X correspond au point (x,y0)
        double[] tab = new double[]{x, this.y0};
        return this.f.getValeur(tab);
    }
}
