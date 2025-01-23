public class MainDerivee {

    static FonctionTraverser ft = new FonctionTraverser(3000, 15000);

    public static double calculerDerivee(double x, double dx){
        System.out.println("Derivé avec x = "+x);
        return (ft.getF(x + dx ) - ft.getF(x))/dx;
    }

    public static void main(String[] args) {

        for (int i = 0; i <= 500; i += 100){
            System.out.println(calculerDerivee(i, 0.001));
        }
    }
}
