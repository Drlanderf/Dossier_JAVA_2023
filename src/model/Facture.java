package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Facture {
    // Propriétés
    private static final double TVA_PERCENTAGE = 0.21;
    private static final int PAYMENT_DEADLINE_DAYS = 7;

    private LocalDate date;
    private ArrayList<Article> articles;
    private Client client;
    private double montantHTVA;
    private double montantTVA;
    private double montantTotalTTC;

    // Constructeurs

    /**
     * Constructeur d'initialisation total
     * @param articles
     * @param client
     */
    public Facture(ArrayList<Article> articles, Client client) {
        this.articles = articles;
        this.client = client;
        this.date = LocalDate.now();
        this.montantHTVA = calculateMontantHTVA();
        this.montantTVA = calculateMontantTVA();
        this.montantTotalTTC = calculateMontantTotalTTC();
    }

    /**
     *
     * @return le calcul du montant HTVA
     */
    private double calculateMontantHTVA() {
        double montant = 0;
        for (Article article : articles) {
            montant += article.getPrixHTVA();
        }
        return montant;
    }

    /**
     *
     * @return le calcul du montant TVA
     */
    private double calculateMontantTVA() {
        return montantHTVA * TVA_PERCENTAGE;
    }

    /**
     *
     * @return le calcul du montant total TTC
     */
    private double calculateMontantTotalTTC() {
        return montantHTVA + montantTVA;
    }

    /**
     *
     * @return une date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @return une liste d'article
     */
    public ArrayList<Article> getArticles() {
        return articles;
    }

    /**
     *
     * @return retourne l'objet client
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @return le montant de la facture HTVA
     */
    public double getMontantHTVA() {
        return montantHTVA;
    }

    /**
     *
     * @return le montant de la TVA
     */
    public double getMontantTVA() {
        return montantTVA;
    }

    /**
     *
     * @return montant total de la facture TTC
     */
    public double getMontantTotalTTC() {
        return montantTotalTTC;
    }
    /**
     *
     * @return La date de deadline du payement
     */
    public LocalDate getPaymentDeadline() {
        return date.plusDays(PAYMENT_DEADLINE_DAYS);
    }

    /**
     * Surcharge de la méthode toString()
     * @return Facture sous forme de String
     */
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
