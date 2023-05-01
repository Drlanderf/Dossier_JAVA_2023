package controler;

import model.ShoppingBasket;
import view.MainGUI;
import view.ShoppingBasketGUI;

public class Main {

    public static void main(String[] args) {
        // créer un panier de shopping
        ShoppingBasket myShoppingBasket = new ShoppingBasket();


        // créer la vue principale
        MainGUI mainGUI = new MainGUI(myShoppingBasket);

        // afficher la vue principale
        mainGUI.show();
    }
}
