package model;

public class Client {
    // Propriétés
    private static final String DEFAULT_NAME = "INPRES";
    private static final String DEFAULT_TVA = "TVA BE 0123 456 789";

    private String name;
    private String tva;

    // Constructeurs
    /**
     * Constructeur par défaut
     */
    public Client() {
        this.name = DEFAULT_NAME;
        this.tva = DEFAULT_TVA;
    }

    /**
     * Constructeur d'initialisation total
     * @param name
     * @param tva
     */
    public Client(String name, String tva) {
        this.name = name;
        this.tva = tva;
    }

    // Getters et setters

    /**
     * getName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getTva
     * @return tva
     */
    public String getTva() {
        return tva;
    }

    /**
     * setTva
     * @param tva
     */
    public void setTva(String tva) {
        this.tva = tva;
    }
}
