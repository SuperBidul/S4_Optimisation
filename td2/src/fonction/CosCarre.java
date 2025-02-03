package fonction;

import static java.lang.Math.cos;

public class CosCarre implements Fonction1D {

    @Override
    public double getF(double x) {
        return cos(x) * Math.pow(x-1, 2);
    }
}
