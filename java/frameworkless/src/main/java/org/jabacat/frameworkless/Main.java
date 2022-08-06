package org.jabacat.frameworkless;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/intro", (exchange -> {

            if ("GET".equals(exchange.getRequestMethod())) {
                String responseText = "Java no framework REST API\n";
                try {
                    exchange.sendResponseHeaders(200, responseText.getBytes().length);
                } catch (Exception send) {
                    System.err.println("Exception sending response");
                }
                OutputStream output = exchange.getResponseBody();
                output.write(responseText.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
            exchange.close();
        }));


        server.setExecutor(null);

        try {
            server.start();
        } catch (Exception start) {
            System.err.println("Server failed to start");
        }

        // use `curl localhost:8080/api/intro`
    }
}
