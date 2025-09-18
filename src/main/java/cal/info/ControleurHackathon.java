package cal.info;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ControleurHackathon implements HttpHandler {

    @Override
    public void handle(HttpExchange echange) throws IOException {
        String typeRequete = echange.getRequestMethod();

        switch (typeRequete) {
            case "GET":
                String filtre = echange.getRequestURI().getQuery();
                if (filtre != null && filtre.contains("nom=")) {
                    String nomHackathon = filtre.split("nom=")[1];
                    rechercheHackathons(echange, nomHackathon);
                } else {
                    listeHackathons(echange);
                }break;
            case "POST":
                ajouterHackathon(echange);
                break;
            case "PUT":
                modifierHackathon(echange);
                break;
            case "DELETE":
                supprimerHackathon(echange);
                break;
            default:
                echange.sendResponseHeaders(405, -1); // Method Not Allowed
                break;
        }
        String response = "Well done";
        echange.sendResponseHeaders(200, response.length());
        OutputStream os = echange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }


    private List<Hackathon> listeHackathons(HttpExchange echange) {


        return null;
    }

    private List<Hackathon> rechercheHackathons(HttpExchange echange, String motHackathon){
        return null;
    }
    

    private void ajouterHackathon(HttpExchange echange){
    }

    private void modifierHackathon(HttpExchange echange) {

    }

    private void supprimerHackathon(HttpExchange echange) {

    }

}
