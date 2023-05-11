package view;

import controler.ArticleControle;
import controler.Controle;
import model.Article;
import model.ShoppingBasket;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



    /* ------------------------------------------------------------
		Event listener for keypad (0 -> 9)
	   ------------------------------------------------------------ */
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                String buttonText = button.getText();
                cbTempField.setText(cbTempField.getText() + buttonText);
            }
        };
        a0Button.addActionListener(buttonListener);
        a1Button.addActionListener(buttonListener);
        a2Button.addActionListener(buttonListener);
        a3Button.addActionListener(buttonListener);
        a4Button.addActionListener(buttonListener);
        a5Button.addActionListener(buttonListener);
        a6Button.addActionListener(buttonListener);
        a7Button.addActionListener(buttonListener);
        a8Button.addActionListener(buttonListener);
        a9Button.addActionListener(buttonListener);
    /* ------------------------------------------------------------
		Event listener for keypad (MultiplyButton)
	   ------------------------------------------------------------ */
        MultiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cbText = cbTempField.getText().trim();
                int cbValue = 0;

                // Vérifier si le texte est un nombre valide
                try {
                    cbValue = Integer.parseInt(cbText);
                }
                catch (NumberFormatException ex) {
                    System.out.println("[MainGUI.MultiplyButton EVENT] Erreur : "+e);
                    // Le texte n'est pas un nombre valide
                    // Gérer l'erreur selon vos besoins
                    return;
                }
                // Limiter le nombre à 2 chiffres maximum
                cbValue = Math.min(cbValue, 99);
                // Mettre à jour le qtyTempField avec la valeur limitée
                qtyTempField.setText(String.valueOf(cbValue));
                // Supprimer le contenu du cbTempField
                cbTempField.setText("");
            }
        });




    /* ------------------------------------------------------------
		Event listener for keypad (Close Window)
	   ------------------------------------------------------------ */
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controle.exitApplication();
            }
        });
    }
}
