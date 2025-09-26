package cal.info;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

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
        String method = echange.getRequestMethod();

        switch (method) {
            case "GET":
                handleGet(echange);
                break;
            case "POST":
                handlePost(echange);
                break;
            default:
                echange.sendResponseHeaders(405, -1); // Method Not Allowed
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
