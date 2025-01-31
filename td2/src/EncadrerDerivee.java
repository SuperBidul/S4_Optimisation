public class EncadrerDerivee {
    Fonction1D f1d;

    public EncadrerDerivee(Fonction1D f1){
        this.f1d = f1;
    }

    public double encadrer(double a, double b){

        //1 Prendre milieu m = a+b
        double milieu = (a + b) / 2;

        while (milieu - a > 0.01 || milieu - b > 0.01) {

            //2 Regarder le signe de f'(m)
            //3 Garder [a, m] ou [m, b] pour avoir deux signes différents de f
            if (f1d.getF(a) * f1d.getF(milieu) < 0) {
                b = milieu;
            } else if (f1d.getF(milieu) * f1d.getF(b) < 0) {
                a = milieu;
            } else {
                return milieu;
            }
            milieu = (a + b) / 2;
        }
        return milieu;
    }
}
