public class MainEncadrerDerivee {
    public static void main(String[] args) {

        Fonction1D fct = new Fonction1D() {
            @Override
            public double getF(double x) {
                return (x-2)*(x-1);
            } };

        EncadrerDerivee ed = new EncadrerDerivee(fct);

        System.out.printf("\nPour la fonction (x − 2) ∗ (x − 1) l'optimum local est environ %2.7f", ed.encadrer(0, 4));

        FonctionTraverser ft = new FonctionTraverser(3000, 15000);

        EncadrerDerivee ed2 = new EncadrerDerivee(ft);

        System.out.printf("\nPour la fonction (x − 2) ∗ (x − 1) l'optimum local est environ %2.7f", ed2.encadrer(0, 500));
    }
}
