package main;

import encadrement.Encadrement;
import fonction.tp1.FonctionTraverser;

public class MainEncadrement {
    public static void main(String[] args) {

        FonctionTraverser ft = new FonctionTraverser(3000, 15000);
        Encadrement en = new Encadrement(ft);

        System.out.println("lorsque le point A est a la verticale du point B, la duree de deplacement est d’environ 0.061512 h");
        System.out.println(ft.getF(500));

        System.out.println("Recherche de l'optimum local");
        en.encadrer(0, 250, 500);

        FonctionTraverser ft2 = new FonctionTraverser(1000, 1000);
        Encadrement en2 = new Encadrement(ft2);

        System.out.println("Recherche de l'optimum local en diagonale");
        en2.encadrer(0, 250, 500);
    }
}
