package model;

public class Client {
    private static final String DEFAULT_NAME = "INPRES";
    private static final String DEFAULT_TVA = "TVA BE 0123 456 789";

    private String name;
    private String tva;

    public Client() {
        this.name = DEFAULT_NAME;
        this.tva = DEFAULT_TVA;
    }

    public Client(String name, String tva) {
        this.name = name;
        this.tva = tva;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }
}
