package model;

public class Vendeur {
    private static final String DEFAULT_FIRST_NAME = "James";
    private static final String DEFAULT_LAST_NAME = "Bond";
    private static final String DEFAULT_MATRICULE = "007";

    private String firstName;
    private String lastName;
    private String matricule;

    public Vendeur() {
        this.firstName = DEFAULT_FIRST_NAME;
        this.lastName = DEFAULT_LAST_NAME;
        this.matricule = DEFAULT_MATRICULE;
    }

    public Vendeur(String firstName, String lastName, String matricule) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}

