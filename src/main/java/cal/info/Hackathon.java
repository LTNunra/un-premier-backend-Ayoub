package cal.info;

public class Hackathon {
    private String nom;
    private String lieu;
    private String description;

    public Hackathon() {
    }

    public Hackathon(String nom, String lieu, String description) {
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
    }

    public String obtenirNom() { return nom; }
    public void definirNom(String nom) { this.nom = nom; }

    public String obtenirLieu() { return lieu; }
    public void definirLieu(String lieu) { this.lieu = lieu; }

    public String obtenirDescription() { return description; }
    public void definirDescription(String description) { this.description = description; }
}
