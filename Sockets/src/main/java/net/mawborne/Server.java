//https://www.baeldung.com/a-guide-to-java-sockets#bd-Overview

package net.mawborne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.*;
import java.io.*;

public class Server {
    private static final Logger LOGGER = LogManager.getLogger(Server.class);

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
             LOGGER.info("Server started on port {}. Waiting for clients...", port);

             try (Socket clientSocket = serverSocket.accept();
                  PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                  BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                 LOGGER.info("Client connected!");
                 String introduction = in.readLine();

                 if ("Hello Server".equals(introduction)) {
                     out.println("Hello Client");
                 }
             }
        } catch (IOException err) {
            LOGGER.error("Server crashed: {}", err.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();

        new Thread(() -> {
            server.start(6666);
        }).start();

        try { Thread.sleep(500); } catch (InterruptedException _) {}

        try (Client client = new Client()) {
            client.startConnection("127.0.0.1", 6666);

            String response = client.sendMessage("Hello Server");
            System.out.println("Server said: " + response);

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
