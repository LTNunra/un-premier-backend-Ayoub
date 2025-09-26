package cal.info;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ControleurHackathon implements HttpHandler {

    private static final List<Hackathon> hackathons = new ArrayList<>();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(HttpExchange echange) throws IOException {
        try {
            String method = echange.getRequestMethod();

            if ("GET".equalsIgnoreCase(method)) {
                handleGet(echange);
            } else if ("POST".equalsIgnoreCase(method)) {
                handlePost(echange);
            } else {
                echange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            String error = "{\"error\":\"" + ex.getMessage() + "\"}";
            echange.getResponseHeaders().add("Content-Type", "application/json");
            echange.sendResponseHeaders(500, error.getBytes().length);
            try (OutputStream os = echange.getResponseBody()) {
                os.write(error.getBytes());
            }
        }
    }

    private void handleGet(HttpExchange echange) throws IOException {
        String response = mapper.writeValueAsString(hackathons);
        echange.getResponseHeaders().add("Content-Type", "application/json");
        echange.sendResponseHeaders(200, response.getBytes().length);
        try (OutputStream os = echange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private void handlePost(HttpExchange echange) throws IOException {
        InputStream body = echange.getRequestBody();

        // désérialiser JSON vers Hackathon
        Hackathon nouveau = mapper.readValue(body, Hackathon.class);
        hackathons.add(nouveau);

        String response = mapper.writeValueAsString(nouveau);
        echange.getResponseHeaders().add("Content-Type", "application/json");
        echange.sendResponseHeaders(201, response.getBytes().length);
        try (OutputStream os = echange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
