package model;

public class Vendeur {
    // Propriétés
    private static final String DEFAULT_FIRST_NAME = "James";
    private static final String DEFAULT_LAST_NAME = "Bond";
    private static final String DEFAULT_MATRICULE = "007";

    private String firstName;
    private String lastName;
    private String matricule;

    // Constructeurs
    /**
     * Constructeur par défaut
     */
    public Vendeur() {
        this.firstName = DEFAULT_FIRST_NAME;
        this.lastName = DEFAULT_LAST_NAME;
        this.matricule = DEFAULT_MATRICULE;
    }

    /**
     * Constructeur d'initialisation total
     * @param firstName
     * @param lastName
     * @param matricule
     */
    public Vendeur(String firstName, String lastName, String matricule) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;
    }

    // Getters et setters

    /**
     * getFirstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getLastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getMatricule
     * @return matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * setMatricule
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}

