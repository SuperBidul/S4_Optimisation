package tp4.ex2.etudiant;



/**
 * permet de generer des points selon une distribution
 */
public interface Generateur {

    /**
     * genere un nouveau point
     *
     * @return un nouveau point2D
     */
    public abstract Point2D getPoint();
}
