package tp4.ex2.etudiant;

import tp4.ex1.fonctionD.FonctionD;

public class FonctionCercle extends FonctionD {

    protected ProblemeRF probleme;

    public FonctionCercle(ProblemeRF probleme) {
        this.probleme = probleme;
        super.nbDim = 3;
    }

    @Override
    public double getValeur(double[] x) {
        Cercle c = new Cercle(x[0], x[1], x[2]);
        return probleme.evaluer(c);
    }
}
