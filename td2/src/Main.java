public class Main {
    public static void main(String[] args) {

        FonctionTraverser ft = new FonctionTraverser(3000, 15000);

        System.out.println("lorsque le point A est a la verticale du point B, la duree de deplacement est d’environ 0.061512 h");
        System.out.println(ft.getF(500));

        System.out.println("lorsque le point A est `a la verticale du point A, la dur´ee de d´eplacement est d’environ 0.197497 h.");
        System.out.println(ft.getF(0));
    }
}