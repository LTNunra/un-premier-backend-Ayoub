package cal.info;

import java.util.List;

public class Etudiant {
    private String nomEtudiant;
    private String ageEtudiant;

    public void obtenirNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public void obtenirAgeEtudiant(String ageEtudiant) {
        this.ageEtudiant = ageEtudiant;
    }

    public void ajouterPreferenceHackathon(Hackathon hackathon) {

    }

    private List<Hackathon> afficherPreferences(){
        return null;
    }
}
