package model;
public class Article {
    // Prorpétés
    private String nom;
    private double prixHTVA;
    private int quantite;
    private String codeBarre;

    // Constructeurs
    /**
     * CONSTRUCTEUR
     * @param nom
     * @param prixHT
     * @param quantite
     * @param codeBarre
     */
    public Article(String nom, double prixHT, int quantite, String codeBarre) {
        this.nom = nom;
        this.prixHTVA = prixHT;
        this.quantite = quantite;
        this.codeBarre = codeBarre;
    }

    // Getters et setters

    /**
     * getNom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * setNom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getPrixHTVA
     * @return prixHTVA
     */
    public double getPrixHTVA() {
        return prixHTVA;
    }

    /**
     * setPrixHTVA
     * @param prixHTVA
     */
    public void setPrixHTVA(double prixHTVA) {
        this.prixHTVA = prixHTVA;
    }

    /**
     * getQuantite
     * @return quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * setQuantite
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * getCodeBarre
     * @return codeBarre
     */
    public String getCodeBarre() {
        return codeBarre;
    }

    /**
     * setCodeBarre
     * @param codeBarre
     */
    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    /**
     * Obtenir le prix TTC (TVA 21%)
     * @return Prix TTC (double)
     */
    public double getPrixTVAC() {
        return prixHTVA * 1.21;
    }

    /**
     * Calculer le montant total d'article
     * @return Prix Total avec TTC (double)
     */
    public double getTotal() {
        return getPrixTVAC() * quantite;
    }

    /**
     * Afficher les détails de l'article
     * @return String
     */
    @Override
    public String toString() {
        return nom + " (code barre : " + codeBarre + ") - " + quantite + " x " + getPrixTVAC() + " € = " + getTotal() + " €";
    }
}




