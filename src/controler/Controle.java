package controler;

import model.Article;
import view.MainGUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Controle {
    // propriétés
    private MainGUI mainGUI;
    private String nomFenetre;


    public static void main(String[] arts){
        new Controle();

    }

    // Constructeurs
    /**
     * Constructeur d'initialisation
     */
    public Controle(){
        try{
            Properties prop = new Properties();
            prop.load(new FileInputStream("resources/config.properties"));
            this.nomFenetre = (String)prop.get("APP_NAME");
            //System.out.println("[Debug config.properties controler] Le nom de l'application est : "+this.nomFenetre );
        } catch(FileNotFoundException e){
            System.out.println("[config.properties controler] Erreur ! Fichier non trouve... "+e);

        } catch (IOException e){
            System.out.println("[config.properties controler] Erreur d'IO : "+e);
        }




        try{
            mainGUI = new MainGUI(this);
            mainGUI.setVisible(true);
        } catch (Exception e){
            System.out.println("[mainGUI controler] Erreur lors de la tentative de création : "+e);
        }
    }
    //Setters et getters


    public String getNomFenetre() {
        return nomFenetre;
    }

    public void setNomFenetre(String nomFenetre) {
        this.nomFenetre = nomFenetre;
    }

    /**
     * Gestion de fermeture d'application
     */
    public void exitApplication() {
        System.exit(0);
    }
}
