package encadrement;

import fonction.Derivee;
import fonction.Fonction1D;

public class DescenteGradient {

    public static final double PAS_APPRENTISSAGE = 0.1;
    public static final int POINT_DEPART = 2;

    Fonction1D fd;
    Fonction1D derivee;
    double a;

    public DescenteGradient(Fonction1D fd, double a) {
        this.fd = fd;
        this.a = a;
        this.derivee = new Derivee(fd, Derivee.DX);
    }

    public double encadrer(double dx, double x){
        //Require: α ≥ 0, dx > 0, x
        if (this.a < 0){
            throw new IllegalArgumentException("le coef d'apprantissage (a) doit etre supérieur à 0");
        }
        if (dx <= 0) {
            throw new IllegalArgumentException("La précision (dx) doit être strictement positive.");
        }

        //while N < 100 do
        for(int i = 0; i < 100; i++) {
            //x ← x − α.derivee
            x -= this.a*derivee.getF(x);
        // end while
        }

        return x;
    }
}
