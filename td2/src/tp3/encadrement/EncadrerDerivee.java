package tp3.encadrement;

import tp3.fonction.utile.Derivee;
import tp3.fonction.Fonction1D;

import static tp3.fonction.utile.Derivee.DX;

public class EncadrerDerivee {

    Fonction1D f1d;

    public EncadrerDerivee(Fonction1D f1){
        this.f1d = new Derivee(f1, DX);
    }

    public double encadrer(double a, double b){

        if(a > b){
            throw new IllegalArgumentException("mauvais ordre des valeurs");
        } else if (f1d.getF(a) * f1d.getF(b) > 0) {
            throw new IllegalArgumentException("Intervalle de dérivée sans changement de signe");
        }

        double milieu = 0;

        while ((b - a) > Derivee.DX) {

            //1 Prendre milieu m = a+b
            milieu = (a + b) / 2;
            System.out.printf("\n%2.7f", milieu);
            //2 Regarder le signe de f'(m)
            //3 Garder [a, m] ou [m, b] pour avoir deux signes différents de f
            if (f1d.getF(a) * f1d.getF(milieu) < 0) {
                b = milieu;
            } else if (f1d.getF(milieu) * f1d.getF(b) < 0) {
                a = milieu;
            } else {
                return milieu;
            }
        }
        return milieu;
    }
}
