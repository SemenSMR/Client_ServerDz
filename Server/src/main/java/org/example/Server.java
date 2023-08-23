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
                    System.out.printf("Новое подключение Port: %d%n ", clientSocket.getPort());
                    final String name = in.readLine();
                    out.println(String.format("Hi %s,\"Сервер временно дорабатывается\" your port is %d", name, clientSocket.getPort()));
                }
            }
        }
    }
}