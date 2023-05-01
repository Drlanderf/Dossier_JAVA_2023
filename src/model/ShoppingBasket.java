package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {
    private Map<String, Article> articles;

    // Constructeur
    public ShoppingBasket() {
        articles = new HashMap<String, Article>();
    }

    // Méthode pour ajouter un article au panier
    public void ajouterArticle(Article article, int quantite) {
        Article articleExistant = articles.get(article.getCodeBarre());
        if (articleExistant != null) {
            articleExistant.setQuantite(articleExistant.getQuantite() + quantite);
        } else {
            article.setQuantite(quantite);
            articles.put(article.getCodeBarre(), article);
        }
    }

    // Méthode pour supprimer un article du panier
    public void supprimerArticle(Article article) {
        articles.remove(article.getCodeBarre());
    }

    // Méthode pour vider le panier
    public void viderPanier() {
        articles.clear();
    }

    // Méthode pour obtenir le nombre d'articles dans le panier
    public int getNombreArticles() {
        int total = 0;
        for (Article article : articles.values()) {
            total += article.getQuantite();
        }
        return total;
    }

    // Méthode pour obtenir le montant total HTVA du panier
    public double getMontantTotalHTVA() {
        double total = 0.0;
        for (Article article : articles.values()) {
            total += article.getPrixHTVA() * article.getQuantite();
        }
        return total;
    }

    // Méthode pour obtenir le montant total TVAC du panier
    public double getMontantTotalTVAC() {
        double total = 0.0;
        for (Article article : articles.values()) {
            total += article.getPrixTVAC() * article.getQuantite();
        }
        return total;
    }
    // Méthode pour obtenir la liste des articles du panier
    public List<Article> getArticles() {
        return new ArrayList<Article>(articles.values());
    }
    // Méthode pour afficher les détails de tous les articles dans le panier
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Panier :\n");
        sb.append(String.format("%-15s%-25s%-15s%-15s%-15s\n", "Code barre", "Nom", "Prix HTVA", "Prix TVAC", "Quantité"));
        for (Article article : articles.values()) {
            sb.append(String.format("%-15s%-25s%-15.2f%-15.2f%-15d\n",
                    article.getCodeBarre(),
                    article.getNom(),
                    article.getPrixHTVA(),
                    article.getPrixTVAC(),
                    article.getQuantite()));
        }
        sb.append(String.format("Total HTVA : %.2f euros\n", getMontantTotalHTVA()));
        sb.append(String.format("Total TVAC : %.2f euros\n", getMontantTotalTVAC()));
        return sb.toString();
    }
}


