package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Старт сервера , сервер работает....");
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {

                    out.println("Hi, Write your name?");
                    String name = in.readLine();
                    out.println("Are you a child? (yes/no):");
                    String answer = in.readLine();
                    String response = answer.equalsIgnoreCase("yes")
                            ? "Welcome to the kids area, " + name + "! Let's play!"
                            : "Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!";
                    out.println(response);
                }
            }
        }
    }
}