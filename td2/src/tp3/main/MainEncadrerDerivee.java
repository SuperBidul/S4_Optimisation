package tp3.main;

import tp3.encadrement.EncadrerDerivee;
import tp3.fonction.Fonction1D;
import tp3.fonction.tp1_.FonctionTraverser;

public class MainEncadrerDerivee {
    public static void main(String[] args) {

        Fonction1D fct = new Fonction1D() {
            @Override
            public double getF(double x) {
                return (x-2)*(x-1);
            } };

        EncadrerDerivee ed = new EncadrerDerivee(fct);

        System.out.printf("\nPour la tp3.fonction (x − 2) ∗ (x − 1) l'optimum local est environ %2.7f", ed.encadrer(0, 4));

        FonctionTraverser ft = new FonctionTraverser(3000, 15000);

        EncadrerDerivee ed2 = new EncadrerDerivee(ft);

        System.out.printf("\nPour la tp3.fonction (x − 2) ∗ (x − 1) l'optimum local est environ %2.7f", ed2.encadrer(0, 500));
    }
}
