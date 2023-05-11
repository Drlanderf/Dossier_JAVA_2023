package view;

import controler.ArticleControle;
import controler.Controle;
import model.Article;
import model.ShoppingBasket;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI extends JFrame {
    // Propriétés
    private Controle controle;
    private ArticleControle Acontrole;

    /**
     * JPanel de base
     */
    private JPanel mainPanel;

    /**
     * Gestion du KeyPad
     */
    private JPanel keyPadPanel;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton clearButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton MultiplyButton;
    private JButton supressButton; //Bouton qui fait office de "delete"
    private JButton a0Button;
    private JButton PointButton;
    private JButton ENTERButton;

    /**
     * Coeur de l'application
     */
    private JPanel shoppingBasketManagerPanel;
    private JTextField qtyTempField;
    private JTextField cbTempField;
    private JLabel qtyLabel;
    private JLabel descriptionLabel;
    private JTextField qty;
    private JTextField description;
    private JButton ajouterAuPanierButton;
    private JButton suprimerDuPanierButton;
    private JTextField a000TextField;
    private JTextField a000TextField1;

    /**
     * Gestions du shoppingBasket
     */
    private JPanel shoppingBasketPanel;
    private JTable shoppingBasketTable;
    private JButton TICKETButton;
    private JButton FACTUREButton;

    // Constructeurs
    /**
     * Constructeur d'initialisation
     * @param controle
     */
    public MainGUI(Controle controle) {
        this.controle = controle;
        setTitle(this.controle.getNomFenetre());
        this.Acontrole = new ArticleControle("resources/Articles.CSV");
        //Acontrole.afficherArticles(); //<=== DebugLine


        add(mainPanel);
        setSize(800, 600);
        setVisible(true);




        //Gestion fermeture application
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controle.exitApplication();
            }
        });
    }
}
