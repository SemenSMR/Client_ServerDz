package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String serverMessage = in.readLine();
            System.out.println(serverMessage);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String name = userInput.readLine();
            out.println(name);

            String secondMessage = in.readLine();
            System.out.println(secondMessage);

            String answer = userInput.readLine();
            out.println(answer);

            String response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}