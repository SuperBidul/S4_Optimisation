public class Encadrement {
    Fonction1D f1D;

    public Encadrement(Fonction1D fd){
        this.f1D = fd;
    }

    public double encadrer(double a, double b, double c){
        double milieu = (a + b) / 2;
        if (a >= b || b >= c){
            throw new IllegalArgumentException("a b et c dans le mauvais ordre");
        } else {
            while (a - milieu <= 0.01 || c - milieu <= 0.01) {
                milieu = (a + b) / 2;
                System.out.println(milieu);

                if (f1D.getF(milieu) < f1D.getF(b)) {
                    c = b;
                    b = milieu;
                } else if (f1D.getF(milieu) > f1D.getF(b)) {
                    a = milieu;
                } else {
                    return milieu;
                }

                milieu = (b + c) / 2;
                System.out.println(milieu);

                if (f1D.getF(milieu) < f1D.getF(b)) {
                    a = b;
                    b = milieu;
                } else if (f1D.getF(milieu) > f1D.getF(b)) {
                    c = milieu;
                } else {
                    return milieu;
                }
            }
        }
        return milieu;
    }
}
