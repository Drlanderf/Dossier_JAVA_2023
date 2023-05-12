package view;

import controler.ArticleControle;
import controler.Controle;
import model.Article;
import model.ShoppingBasket;
import model.ShoppingBasketTableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class MainGUI extends JFrame {
    // Propriétés
    private Controle controle;
    private ArticleControle Acontrole;
    private ShoppingBasket shoppingBasket = new ShoppingBasket();
    private String _codeBarre;


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
    private JTextField prixTot;
    private JTextField prixUnit;

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
        String codeBarre = null;
        this.controle = controle;
        setTitle(this.controle.getNomFenetre());
        this.Acontrole = new ArticleControle("resources/Articles.CSV");
        //Acontrole.afficherArticles(); //<=== DebugLine




        add(mainPanel);
        setSize(900, 600);
        setVisible(true);


    /* ------------------------------------------------------------
		Event listener for keypad
	   ------------------------------------------------------------ */
/**
 * Boutons 0 -> 9, permet d'encoder le code-barre et/ou donner l'information de la quantité souhaitée
 */
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
/**
 * Bouton Multiplication, pour set la quantité
 */
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
/**
 * Bouton suppression, pour suprimer le dernier caractère dans le code barre
 */
        supressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cbText = cbTempField.getText().trim();

                // Vérifier si le champ n'est pas vide
                if (!cbText.isEmpty()) {
                    // Supprimer le dernier caractère
                    cbText = cbText.substring(0, cbText.length() - 1);

                    // Mettre à jour le cbTempField avec la nouvelle valeur
                    cbTempField.setText(cbText);
                }
            }
        });
/**
 * Bouton entré, permet de poursuivre l'utilisation de la caisse enregistreuse
 */
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codeBarre = cbTempField.getText();
                Article article = Acontrole.findArticleByCodeBarre(codeBarre);

                if (article == null) {
                    // Article non trouvé, afficher un message d'erreur
                    JOptionPane.showMessageDialog(null, "Article non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);
                    clearFields();
                } else {
                    String qtyInput = qtyTempField.getText();

                    if (qtyInput.equals("00")) {
                        // Quantité invalide, afficher un message d'erreur et annuler l'ajout
                        JOptionPane.showMessageDialog(null, "Quantité invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
                        clearFields();
                    } else {
                        int requestedQuantity = Integer.parseInt(qtyInput);
                        int availableQuantity = article.getQuantite();

                        if (requestedQuantity > availableQuantity) {
                            // Demande de quantité supérieure à la quantité disponible
                            int choice = JOptionPane.showOptionDialog(null,
                                    "La quantité demandée est supérieure à la quantité disponible. Voulez-vous continuer ?",
                                    "Quantité insuffisante",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.WARNING_MESSAGE,
                                    null,
                                    new String[]{"Continuer", "Annuler"},
                                    "default");

                            if (choice == JOptionPane.YES_OPTION) {
                                clearFields();
                                _codeBarre = codeBarre;
                                // Continuer normalement, mettre la quantité au maximum disponible
                                qty.setText(String.valueOf(availableQuantity));
                                description.setText(article.getNom());
                                prixUnit.setText(String.format("%.2f", article.getPrixTVAC()));
                                double prixTotal = article.getPrixTVAC() * availableQuantity;
                                prixTot.setText(String.format("%.2f", prixTotal));
                            } else {
                                // Annuler l'ajout, réinitialiser les champs
                                clearFields();
                            }
                        } else {
                            clearFields();
                            // Quantité suffisante, mettre les informations dans les champs
                            _codeBarre = codeBarre;
                            qty.setText(String.valueOf(requestedQuantity));
                            description.setText(article.getNom());
                            prixUnit.setText(String.format("%.2f", article.getPrixTVAC()));
                            double prixTotal = article.getPrixTVAC() * requestedQuantity;
                            prixTot.setText(String.format("%.2f", prixTotal));
                        }
                    }
                }
            }
        });
/**
 * Bounton ajouterAuPanier, permet d'envoyer l'article encoder dans le panier
 */
        ajouterAuPanierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les valeurs des champs
                //String codeBarre = cbTempField.getText();
                int quantite = Integer.parseInt(qty.getText());

                // Récupérer l'article correspondant au code-barre
                Article article = Acontrole.findArticleByCodeBarre(_codeBarre);

                // Vérifier si l'article existe
                if (article != null) {
                    // Ajouter l'article au panier
                    shoppingBasket.ajouterArticle(article, quantite);
                    shoppingBasket.afficherPanier();


                    // Réinitialiser les champs
                    clearFields();
                } else {
                    // Afficher un message d'erreur si l'article n'est pas trouvé
                    JOptionPane.showMessageDialog(null, "Article non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });





     /* ------------------------------------------------------------
		//TODO : travailler sur la JTABLE
	   ------------------------------------------------------------ */





/**
 * Bouton clear, permet de remettre à 0 tous les champs
 */
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
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

    /**
     * Permet de Clear les différents champs de l'application
     */
    private void clearFields() {
        qtyTempField.setText("00");
        cbTempField.setText("");
        qty.setText("00");
        description.setText("");
        prixUnit.setText("0.00");
        prixTot.setText("0.00");
    }
}
