package cal.info;

public class Etudiant {
    private String nomEtudiant;
    private int ageEtudiant;
    private String programme;

    public Etudiant(String nomEtudiant, int ageEtudiant, String programme) {
        this.nomEtudiant = nomEtudiant;
        this.ageEtudiant = ageEtudiant;
        this.programme = programme;
    }

    public String getNomEtudiant() {
        return this.nomEtudiant;
    }

    public int getAgeEtudiant() {
        return this.ageEtudiant;
    }

    public String getProgramme() {
        return programme;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public void setAgeEtudiant(int ageEtudiant) {
        this.ageEtudiant = ageEtudiant;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }
}
