import java.awt.*;

public class Main {
    public static void main(String[] args) {

        FonctionTraverser ft = new FonctionTraverser(3000, 15000);

        System.out.println("lorsque le point A est a la verticale du point B, la duree de deplacement est d’environ 0.061512 h");
        System.out.println(ft.getF(500));

        System.out.println("lorsque le point A est `a la verticale du point A, la dur´ee de d´eplacement est d’environ 0.197497 h.");
        System.out.println(ft.getF(0));

        Affichage a = new Affichage(1000, 600, "Fct traverse");
        a.setXMinMax(0,500);
        a.setYMinMax(ft);
        a.afficher(ft, Color.BLUE);

        Tangeante t = new Tangeante(ft, 200);
        a.afficher(t, Color.red);

        a.dessinerPoint(200, ft.getF(200));

        a.rendreEcran();
    }
}