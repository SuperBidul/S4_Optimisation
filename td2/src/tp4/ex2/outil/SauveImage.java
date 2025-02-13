package tp4.ex2.outil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SauveImage {

    public static String REPERTOIRE = ".";

    public static void sauverImage(BufferedImage image, String nom) {
        // si repertoire existe pas
        File f = new File(REPERTOIRE);
        // le creer
        if (!f.exists()){
            f.mkdir();
        }

        // sauver image
        String name = REPERTOIRE + "/" + nom;

        // si une erreur, stoppe tout.
        try {
            ImageIO.write(image, "PNG", new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
