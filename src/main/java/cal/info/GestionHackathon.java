package cal.info;

import java.util.ArrayList;
import java.util.List;

public class GestionHackathon {
    public List<Hackathon> hackathons = new ArrayList();

    public void ajouterHackathon(Hackathon hackathon) {
        hackathons.add(hackathon);
    }

    public List<Hackathon> retrouverHackathons() {
        return hackathons;
    }

    public void modifierHackathon(Hackathon hackathon) {

    }

    public void creerEtudiants(List<Etudiant>  etudiants) {

    }

    public void formerEquipe(List<Etudiant> etudiants, String nomEquipe) {

    }


}
