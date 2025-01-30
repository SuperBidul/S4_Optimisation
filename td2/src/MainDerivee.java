public class MainDerivee {
    public static void main(String[] args) {

        FonctionTraverser ft = new FonctionTraverser(3000, 15000);

        Derivee derive = new Derivee(ft, 0.001);

        Encadrement en = new Encadrement(ft);

        System.out.println("test de la classe Derive :");
        for (int i = 0; i <= 500; i += 100){
            System.out.println("x = "+i);
            System.out.printf("%2.7f\n",derive.getF(i));
        }

        System.out.println("\ntest de la classe Derivee avec encadrer :");
        System.out.printf("%2.10f", en.encadrer(derive.getF(0),derive.getF(250), derive.getF(500)));

        System.out.println("Tests de la classe Derivee de la fonction (x − 2) ∗ (x − 1)");

        Fonction1D fct = new Fonction1D() {
            @Override
            public double getF(double x) {
            return (x-2)*(x-1);
        } };

        Derivee derive2 = new Derivee(fct, 0.001);

        for (int i = 0; i <= 5; i += 1){
            System.out.println("x = "+i);
            System.out.printf("%2.2f\n",derive2.getF(i));
        }
    }
}
