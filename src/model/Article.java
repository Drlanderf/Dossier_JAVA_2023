package model;
public class Article {
    private String nom;
    private double prixHTVA;
    private int quantite;
    private String codeBarre;

    // Constructeur
    public Article(String nom, double prixHT, int quantite, String codeBarre) {
        this.nom = nom;
        this.prixHTVA = prixHT;
        this.quantite = quantite;
        this.codeBarre = codeBarre;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getPrixHTVA() {
        return prixHTVA;
    }
    public void setPrixHTVA(double prixHTVA) {
        this.prixHTVA = prixHTVA;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public String getCodeBarre() {
        return codeBarre;
    }
    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    // Méthode pour obtenir le prix TTC de l'article (avec TVA à 21%)
    public double getPrixTVAC() {
        return prixHTVA * 1.21;
    }

    // Méthode pour calculer le montant total de l'article (quantité * prix TTC)
    public double getTotal() {
        return getPrixTVAC() * quantite;
    }

    // Méthode pour afficher les détails de l'article
    @Override
    public String toString() {
        return nom + " (code barre : " + codeBarre + ") - " + quantite + " x " + getPrixTVAC() + " € = " + getTotal() + " €";
    }
}




