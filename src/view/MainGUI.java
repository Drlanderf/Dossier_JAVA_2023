package view;

import javax.swing.*;
import java.awt.*;

import model.ShoppingBasket;

public class MainGUI extends JFrame {
    private JPanel mainPanel;

    public MainGUI(ShoppingBasket shoppingBasket) {
        super("Ma boutique");

        // Créer une instance de ShoppingBasketGUI
        ShoppingBasketGUI shoppingBasketGUI = new ShoppingBasketGUI(shoppingBasket);

        // Récupérer le JPanel de ShoppingBasketGUI
        JPanel shoppingBasketPanel = shoppingBasketGUI.getMainFrame();

        // Ajouter le JPanel de ShoppingBasketGUI à la position est de MainGUI
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(shoppingBasketPanel, BorderLayout.EAST);

        // Ajouter le JPanel de MainGUI au JFrame
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Créer une instance de ShoppingBasket
        ShoppingBasket myShoppingBasket = new ShoppingBasket();

        // Créer une instance de MainGUI en utilisant l'objet ShoppingBasket créé précédemment
        MainGUI mainGUI = new MainGUI(myShoppingBasket);
    }
}
