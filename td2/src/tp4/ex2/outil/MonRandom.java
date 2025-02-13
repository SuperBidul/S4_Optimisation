package tp4.ex2.outil;

import java.util.Random;

public class MonRandom {

    static Random rand = new Random();

    /**
     * intialisation de la graine
     * @param seed graine
     */
    public static void initialiserRandom(int seed){
        rand = new Random(seed);
    }

    public static double rand(){
        return(rand.nextDouble());
    }

    public static int nextInt(int size) {
        return rand.nextInt(size);
    }
}
