package tp3.affichage;// import classes graphiques
import tp3.fonction.Fonction1D;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

import javax.imageio.*;

// pour entree sorties (fichiers)
import java.io.*;

// import classes fonction1D



/**
 * classe destinee a afficher une tp3.fonction
 */

public class Affichage{

    /**
     * l'image destinee a contenir le rendu
     */
    BufferedImage rendu;

    /**
     * les intervalle des axes
     */
    double xmin, xmax;
    double ymin, ymax;

    /**
     * titre
     */
    String titre = "TODO";

    /**
     * taille de l'image
     */
    int tailleX, tailleY;

    /**
     * constructeur vide
     * @param tX taille de fenetre en pixels
     * @param tY taille de fenetre en pixels
     * @param nom titre du graphique
     */
    public Affichage(int tX, int tY, String nom){
        // taille par defaut
        this.xmin = -100;
        this.xmax = +100;
        this.ymin = -100;
        this.ymax = +100;

        // titre
        this.titre = nom;

        // taille par defaut
        this.tailleX = tX;
        this.tailleY = tY;

        // contruire image vide
        this.construireImage();
    }

    /**
     * construit une image vide
     */
    public void construireImage(){
        // creation du buffered image
        this.rendu = new BufferedImage(tailleX,tailleY,BufferedImage.TYPE_3BYTE_BGR);

        // dessin fond blanc
        Graphics g = this.rendu.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,tailleX,tailleY);

        // ecrire titre
        g.setColor(Color.BLACK);
        g.drawString(this.titre,20,20);

        // redessine les axes
        this.dessinerAxes();
    }





    /**
     * afficher une courbe
     * @param fonction la courbe qu'on souhaite tracer
     * @param col la couleur de trace (utiliser une constante définie en java Color.BLUE par ex)
     */
    public void afficher(Fonction1D fonction, Color col){

        // doit ajouter l'image à l'ecran

        //##############################
        // 1. pour chaque pixel, trouver valeur x
        // 2. calculer f(x) et trouver pixel
        // 3. tracer une ligne entre point et ancien point
        //##############################

        // recuperer graphics
        Graphics2D g = (Graphics2D) this.rendu.getGraphics();
        g.setColor(col);

        int oldx = -1;
        int oldy = -1;

        // pour chaque pixel
        for (int i=0;i<tailleX;i++){
            // calculer la valeur de x de la courbe correspondante
            double x = transformerPixelToX(i);

            // calculer f(x)
            double f_x = fonction.getF(x);

            // localiser transformer f(x) en coordonnees pixel
            int posY = transformerYToPixel(f_x);

            // afficher (i,posY)
            g.drawLine(oldx, oldy, i, posY);
            oldx = i;
            oldy = (int) posY;
        }

    }



    /**
     * set ymin et ymax automatique a partir d'une tp3.fonction.
     * La tp3.fonction est entièrement affichee entre xmin et xmax
     *
     *@param f la tp3.fonction a utiliser pour determiner l'echelle
     */
    public void setYMinMax(Fonction1D f){

        // initialisation au max et min double
        this.ymax = -Double.MAX_VALUE;
        this.ymin = Double.MAX_VALUE;

        // recherche min et max de la valeur de la tp3.fonction
        for (int i=0;i<tailleX;i++){
            // calculer la valeur de x correspondante
            double x = transformerPixelToX(i);

            // calculer f(x)
            double f_x = f.getF(x);

            // mise à jour min et max
            if (f_x>this.ymax){
                this.ymax = f_x;
            }

            if (f_x<this.ymin){
                this.ymin = f_x;
            }
        }

        // Ajouter facteur 0.1 pour etre sur que le courbe rentre
        double FACTEUR = 0.1;
        double diff = (this.ymax-this.ymin);
        ymax += FACTEUR*diff;
        ymin -= FACTEUR*diff;

        // reconstruit les axes
        this.construireImage();
    }


    /**
     * Afficher un point de coordonnes (x,y) dans le repere
     *
     *@param x valeur de x
     *@param y valeur de y
     */
    public void dessinerPoint(double x, double y){

        //##############################
        // afficher (x,y) au bon endroit
        // 1. transformer x en pixel (bonne place)*
        // 2. transformer y en pixel
        // 3. dessiner un tp3.cercle de rayon 2 (g.drawOval(x,y,2,2))
        //##############################

        int py = this.transformerYToPixel(y);
        int px = this.transformerXToPixel(x);
        Graphics g = this.rendu.getGraphics();
        g.setColor(Color.RED);
        g.fillOval(px-5,py-5,10,10);

    }




    // #########################################################
    // METHODE DE TRANSFORMATION
    // #########################################################

    /**
     * transformer coordoonees x entre xmin et xmax => num de pixel
     * @param x valeur de x
     * @return position du pixel de coordonnee x sur l'image
     */
    public int transformerXToPixel(double x){
        // si x = xmax => doit retourner tailleX
        // si x = xmin => doit retourner 0
        int px = (int)(tailleX * (x - xmin)/(xmax-xmin));
        return px;
    }

    /**
     * transformer pixel X => x entre min et xmax
     * @param px position du pixel sur l'image selon x
     * @return valeur de x correspondant
     */
    public double transformerPixelToX(int px){
        // si px = tailleX => doit retourner xmax
        // si px = 0 => doit retourner xmin
        return xmin + (px*(xmax-xmin))/(tailleX);
    }


    /**
     * transformer coordoonees y entre ymin et ymax => num de pixel
     * @param y valeur de y
     * @return position du pixel de coordonnee y sur l'image
     */
    public int transformerYToPixel(double y){
        // si y = ymin => doit retourner tailleY (car image inversee verticalement)
        // si y = ymax => doit retourner 0 (car image inversee verticalement)
        int py = (int)(tailleY - tailleY * (y - ymin)/(ymax-ymin));
        return py;
    }

    /*
    /**
     * transformer pixel Y => y entre ymin et ymax
     * @param py position y du pixel
     * @param valeur correspondante selon y

    public int transformerPixelToY(int py){
        // si py = 0 => retourner ymax
        // si py = TAILLEY => retourner ymin
        throw new Error("TODO");
    }
    */

    // #########################################################
    // METHODES UTILES
    // #########################################################


    /**
     * rendu a l'ecran de l'image
     */
    public void rendreEcran(){
        // creation de la frame (fenetre) pour contenir l'image
        JFrame frame = new JFrame();

        // le panel qui affiche avec redefinition de la methode repaint
        JPanel panel = new JPanel() {
            Image im = rendu;
            public void paint(Graphics g){
                g.drawImage(this.im,0,0,null);
            }
        };

        // ajout du panel dans la frame
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel,BorderLayout.CENTER);

        // gestion de la taille des fenetres
        panel.setPreferredSize(new Dimension(this.rendu.getWidth(), this.rendu.getHeight()));
        frame.pack();

        // pack et rendre visible et gestion de la fermeture
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    /**
     * clear permet de vider une figure
     */
    public void clear(){
        // on reconstruit l'image
        this.construireImage();
    }

    /**
     * permet de sauver l'image construite dans un fichier
     *
     * @param nom nom du fichier
     */
    public void sauverImage(String nom){
        try{
            // sauvegarde de l'image
            ImageIO.write(this.rendu,"png",new File(nom));
        }
        catch(IOException e)
        {
            // gestion des problemes entree / sortie
            System.out.println("### Erreur à la sauvegarde "+nom);
            e.printStackTrace();
        }
    }

    /**
     * Permet de modifier l'intervale sur X (echelle) pour le tp3.affichage
     *
     * @param min valeur minimale de x
     * @param max valeur maximale de x
     */
    public void setXMinMax(double min, double max){
        this.xmax = max;
        this.xmin = min;

        // reconstruit l'image et les axes
        this.construireImage();
    }


    /**
     * permet de modifier le titre du graphique
     *
     * @param nom nouveau titre
     */
    public void setTitre(String nom){
        this.titre = nom;
        // reconstruit image
        this.construireImage();
    }

    /**
     * permet de modifier l'intervale sur Y (echelle verticale) pour l'tp3.affichage
     *
     * @param min valeur minimale de y
     * @param max valeur maximale de y
     */
    public void setYMinMax(double min, double max){
        this.ymax = max;
        this.ymin = min;

        // reconstruit image
        this.construireImage();
    }



    // ###########################################################
    // METHODE INTERMEDAIRE
    // ###########################################################


    /**
     * permet de dessiner les axes sur la figure
     * methode appelee automatiquement au dessin d'une figure
     */
    public void dessinerAxes(){
        Graphics g = this.rendu.getGraphics();
        g.setColor(Color.BLACK);

        // positionnement par defaut de la graduation sur X
        int posY = tailleY - 30;

        // si l'axe x est visible (car ymin<0<ymax)
        if ((0<this.ymax)&&(this.ymin<0)) {
            // position du 0
            posY = transformerYToPixel(0);
            // tracer droite horizontale en posY
            g.drawLine(0, posY,tailleX, posY);
        }

        // ###########################
        // Gestion des graduations axe X
        // ###########################

        // graduation
        // trouver ordre de grandeur
        int ordreX = (int)(Math.log10((xmax-xmin)));

        // ordre -1
        ordreX = ordreX -1;
        double graduation = Math.pow(10,ordreX);

        // imin et imax (les graduations à afficher)
        int iminX = (int)(xmin / graduation);
        int imaxX = (int)(xmax / graduation);

        int NBGRADUATIONS_MAX = 8;

        // limiter le nombre de graduations
        int nbGradX = imaxX-iminX;
        // tant qu'il y a trop de graduations
        while (nbGradX > NBGRADUATIONS_MAX){
            // on multiplie par deux la graduation pour réduire le nombre
            graduation = graduation *2;

            // imin et imax (les indices des nouvelles graduations à afficher)
            iminX = (int)(xmin / graduation);
            imaxX = (int)(xmax / graduation);

            // recompte le nombre de graduations
            nbGradX = imaxX-iminX;
        }

        // dessin des graduations
        // pour chaque graduation à dessiner
        for (int i=iminX;i<imaxX;i++){
            // calcul de la valeur de la graduation
            double val = i*graduation;
            // positionne la graduation sur axe x
            int posX = transformerXToPixel(val);
            // dessin graduation
            g.drawLine(posX, posY-5, posX, posY+5);
            // formatte le numero avec ordre de grandeur
            String format = "%.0f";
            if (ordreX<1)
                format= "%."+(-ordreX)+"f";
            String valS = String.format(format,val);
            g.drawString(valS,posX-5,(int)posY-10);
        }


        // ###########################
        // Gestion des graduations axe Y
        // ###########################

        int posX = tailleX-30;

        // si axe est visible car x=0 sur la figure
        if ((this.xmin<0)&&(0<this.xmax)){
            posX = transformerXToPixel(0);
            g.drawLine(posX,0,posX,tailleY);
        }

        // graduation
        // trouver ordre de grandeur
        int ordreY = (int)(Math.log10((ymax-ymin)));

        // ordre -1
        ordreY = ordreY -2;
        double graduationY = Math.pow(10,ordreY);

        // imin et imax (les graduations à afficher)
        int iminY = (int)(ymin / graduationY);
        int imaxY = (int)(ymax / graduationY);

        // nombre grad
        int nbGradY = imaxY-iminY;
        // tant qu'il y a trop de graduation
        while (nbGradY > NBGRADUATIONS_MAX){
            // on multiplie par deux la valeur associee a la graduation
            graduationY = graduationY *2;
            // imin et imax (les graduations à afficher)
            iminY = (int)(ymin / graduationY);
            imaxY = (int)(ymax / graduationY);

            // recompte le nombre de graduations
            nbGradY = imaxY-iminY;
        }

        // dessin des graduations
        // pour chaque graduation
        for (int i=iminY;i<imaxY;i++){
            // calculer la valeur associee
            double val = i*graduationY;
            // positionner la graduation sur axe y
            int gradPosY = transformerYToPixel(val);
            // dessine la graduation
            g.drawLine( posX-5, gradPosY, posX+5, gradPosY);
            // formatte le numero avec ordre de grandeur
            String format = "%.0f";
            if (ordreY<1)
                format= "%."+(-ordreY)+"f";
            String valS = String.format(format,val);
            g.drawString(valS, posX-30, gradPosY);
        }

    }




}