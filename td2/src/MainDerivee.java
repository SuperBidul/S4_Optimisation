public class MainDerivee {
    public static void main(String[] args) {

        FonctionTraverser ft = new FonctionTraverser(3000, 15000);

        Derivee derive = new Derivee(ft, 0.001);

        Encadrement en = new Encadrement(ft);

        System.out.println("test de la classe Derive :");
        for (int i = 0; i <= 500; i += 100){
            System.out.println("x = "+i);
            System.out.println(derive.getF(i));
        }

        System.out.println("test de la classe Derivee avec encadrer :");
        System.out.println(en.encadrer(derive.getF(0),derive.getF(250), derive.getF(500)));
    }
}
