package view;

import controler.Controle;

import javax.swing.*;

public class MainGUI extends JFrame {
    // Propriétés
    private Controle controle;

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
        super("Ma boutique");
        this.controle = controle;
}}
