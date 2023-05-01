package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Facture {
    private static final double TVA_PERCENTAGE = 0.21;
    private static final int PAYMENT_DEADLINE_DAYS = 7;

    private LocalDate date;
    private ArrayList<Article> articles;
    private Client client;
    private double montantHTVA;
    private double montantTVA;
    private double montantTotalTTC;

    public Facture(ArrayList<Article> articles, Client client) {
        this.articles = articles;
        this.client = client;
        this.date = LocalDate.now();
        this.montantHTVA = calculateMontantHTVA();
        this.montantTVA = calculateMontantTVA();
        this.montantTotalTTC = calculateMontantTotalTTC();
    }

    private double calculateMontantHTVA() {
        double montant = 0;
        for (Article article : articles) {
            montant += article.getPrixHTVA();
        }
        return montant;
    }

    private double calculateMontantTVA() {
        return montantHTVA * TVA_PERCENTAGE;
    }

    private double calculateMontantTotalTTC() {
        return montantHTVA + montantTVA;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public Client getClient() {
        return client;
    }

    public double getMontantHTVA() {
        return montantHTVA;
    }

    public double getMontantTVA() {
        return montantTVA;
    }

    public double getMontantTotalTTC() {
        return montantTotalTTC;
    }

    public LocalDate getPaymentDeadline() {
        return date.plusDays(PAYMENT_DEADLINE_DAYS);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Facture\n");
        sb.append("Date : " + date.toString() + "\n");
        sb.append("Echéance de paiement : " + getPaymentDeadline().toString() + "\n");
        sb.append("Client : " + client.getName() + "\n");
        sb.append("TVA : " + client.getTva() + "\n");
        sb.append("Articles :\n");
        for (Article article : articles) {
            sb.append("- " + article.getNom() + " : " + article.getPrixTVAC() + "€\n");
        }
        sb.append("Montant HTVA : " + montantHTVA + "€\n");
        sb.append("TVA (" + (TVA_PERCENTAGE * 100) + "%) : " + montantTVA + "€\n");
        sb.append("Montant total TTC : " + montantTotalTTC + "€\n");
        return sb.toString();
    }
}
