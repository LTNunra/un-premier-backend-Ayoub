package cal.info;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ControleurHackathon implements HttpHandler {

    public GestionHackathon gestionHackathon = new GestionHackathon();

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
                }
                break;
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
    }

    private void ajouterHackathon(HttpExchange echange) throws IOException {
        InputStream corpRequete = echange.getRequestBody();
        InputStreamReader lecteur = new InputStreamReader(corpRequete, StandardCharsets.UTF_8);

        Gson gson = new Gson();
        Hackathon hackathonDeserialse = gson.fromJson(lecteur, Hackathon.class);

        gestionHackathon.ajouterHackathon(hackathonDeserialse);

        String reponse = "Le Hackathon a bien été ajouté";
        byte[] reponseEncodee = reponse.getBytes(StandardCharsets.UTF_8);

        echange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
        echange.sendResponseHeaders(201, reponseEncodee.length);

        OutputStream os = echange.getResponseBody();
        os.write(reponseEncodee);
        os.close();
    }

    private void listeHackathons(HttpExchange echange) throws IOException {

        List<Hackathon> hackathons = gestionHackathon.retrouverHackathons();

        Gson gson = new Gson();
        String reponse = gson.toJson(hackathons);
        byte[] reponseEncode = reponse.getBytes(StandardCharsets.UTF_8);

        // Set response headers and send the response
        echange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        echange.sendResponseHeaders(200, reponseEncode.length);

        OutputStream os = echange.getResponseBody();
        os.write(reponseEncode);
        os.close();

    }


    private void rechercheHackathons(HttpExchange echange, String motHackathon) throws IOException {

        String response = "Well done";
        echange.sendResponseHeaders(200, response.length());
        OutputStream os = echange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }





    private void modifierHackathon(HttpExchange echange) {

    }

    private void supprimerHackathon(HttpExchange echange) {

    }

}
