package cal.info;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        HttpServer serveur = HttpServer.create(new InetSocketAddress(8000), 0);

        // Route pour les hackathons
        serveur.createContext("/hackathons", new ControleurHackathon());

        serveur.setExecutor(null);
        System.out.println("Serveur lancé sur http://localhost:8000");
        serveur.start();
    }
}
