package tp4;

import fonction.Fonction1D;

public class FonctionCoupeY implements Fonction1D {

    FonctionD f;
    double x0;

    public FonctionCoupeY(FonctionD f, double x0) {
        if(f.nbDim != 2){
            throw new IllegalArgumentException("erreur de dimensions");
        }

        this.f = f;
        this.x0 = x0;
    }

    @Override
    public double getF(double y) {
        //valeur de la coupe en X correspond au point (x,y0)
        double[] tab = new double[]{y, this.x0};
        return this.f.getValeur(tab);
    }
}
