package controler;

import view.MainGUI;

public class Controle {
    // propriétés
    private MainGUI mainGUI;


    public static void main(String[] arts){
        new Controle();

    }

    // Constructeurs
    /**
     * Constructeur d'initialisation
     */
    public Controle(){
        try{
            mainGUI = new MainGUI(this);
            mainGUI.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
