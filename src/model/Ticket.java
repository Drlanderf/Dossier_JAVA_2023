package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {

    private ShoppingBasket basket;
    private Date date;
    private String cashier;

    // Constructeur
    public Ticket(ShoppingBasket basket, String cashier) {
        this.basket = basket;
        this.date = new Date();
        this.cashier = cashier;
    }

    // Méthode pour obtenir le contenu du ticket
    public String getContents() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket de caisse \n");
        sb.append("Date : ").append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date)).append("\n");
        sb.append("Vendeur : ").append(cashier).append("\n");
        sb.append(String.format("%-15s %-20s %-10s %-10s %-10s\n", "Code Barre", "Nom", "Prix HTVA", "Prix TVAC", "Quantité"));
        for (Article article : basket.getArticles()) {
            sb.append(String.format("%-15s %-20s %-10s %-10s %-10s\n", article.getCodeBarre(), article.getNom(), article.getPrixHTVA() + " €", article.getPrixTVAC() + " €", article.getQuantite()));
        }
        sb.append("\nTotal : ").append(basket.getMontantTotalTVAC()).append(" euros");
        return sb.toString();
    }
}



